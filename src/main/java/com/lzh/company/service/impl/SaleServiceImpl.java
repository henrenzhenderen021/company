package com.lzh.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzh.company.mapper.SaleMapper;
import com.lzh.company.mapper.SlipMapper;
import com.lzh.company.mapper.StockMapper;
import com.lzh.company.mapper.UserMapper;
import com.lzh.company.pojo.Sale;
import com.lzh.company.pojo.Slip;
import com.lzh.company.pojo.Stock;
import com.lzh.company.pojo.User;
import com.lzh.company.pojo.request.ProSale;
import com.lzh.company.pojo.request.SProduct;
import com.lzh.company.pojo.response.lSlip;
import com.lzh.company.pojo.response.rSale;
import com.lzh.company.pojo.response.rSlip;
import com.lzh.company.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private SlipMapper slipMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean add(ProSale proSale) {
        Integer userId = proSale.getUser_id();
        Integer customerId = proSale.getCustomer_id();
        Integer storeId = proSale.getStore_id();
        List< SProduct> products = proSale.getProducts();
        slipMapper.insert(customerId, storeId, userId);
        Integer slipId = slipMapper.count();
        for(SProduct product : products){
            Integer productId = product.getProduct_id();
            Integer productNum = product.getProduct_num();
            Stock stock = stockMapper.select(storeId, productId);
            if(stock.getProductNum() < productNum){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
            saleMapper.insert(slipId, productId, productNum);
        }
        return true;
    }

    @Override
    public boolean examine(Integer userId, Integer slipId, Integer state) {
        User user = userMapper.selectById(userId);
        if(user.getUserType().equals("clerk")){
            return false;
        }
        if(state == 0){
            slipMapper.setStatus(slipId, userId, "fail");
        }
        else {
            slipMapper.setStatus(slipId, userId, "pass");
            List<Sale> sales = saleMapper.getProduct(slipId);
            Integer storeId = slipMapper.getStore(slipId);
            for(Sale sale : sales){
                Stock stock = stockMapper.select(storeId, sale.getProductId());
                stockMapper.update(storeId, sale.getProductId(), stock.getProductNum() - sale.getSaleNum());
            }
        }
        return true;
    }

    @Override
    public void delete(Integer slipId) {
        slipMapper.setOnlyStatus(slipId, "return");
        List<Sale> sales = saleMapper.getProduct(slipId);
        Integer storeId = slipMapper.getStore(slipId);
        for(Sale sale : sales){
            Stock stock = stockMapper.select(storeId, sale.getProductId());
            stockMapper.update(storeId, sale.getProductId(), stock.getProductNum() + sale.getSaleNum());
        }
    }

    @Override
    public rSlip detail(Integer slipId) {
        List<rSale> sales = saleMapper.getProductPlus(slipId);
        Slip slip = slipMapper.getDetail(slipId);
        rSlip rslip = new rSlip();
        rslip.setProducts(sales);
        rslip.setStoreName(slip.getStoreName());
        rslip.setCreateTime(slip.getCreateTime());
        rslip.setUpdateTime(slip.getUpdateTime());
        return rslip;
    }

    @Override
    public List<lSlip> list(Integer state, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        String status = switch (state) {
            case 0 -> "admit";
            case 1 -> "pass";
            case 2 -> "fail";
            default -> "return";
        };
        List<lSlip> lSlips = slipMapper.selectByState(status);
        Page<lSlip> slipPage = new Page<>();
        slipPage.addAll(lSlips);
        return slipPage;
    }
}
