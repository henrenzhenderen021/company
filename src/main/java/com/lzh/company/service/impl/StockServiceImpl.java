package com.lzh.company.service.impl;

import com.lzh.company.mapper.StockMapper;
import com.lzh.company.pojo.Store;
import com.lzh.company.pojo.request.SProduct;
import com.lzh.company.pojo.Stock;
import com.lzh.company.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public void add(Integer storeId, List<SProduct> products) {
        for (SProduct product: products) {
            Integer id = product.getProduct_id();
            Integer num = product.getProduct_num();
            Stock stock = stockMapper.select(storeId, id);
            if (stock == null) {
                stockMapper.insert(storeId, id, num);
            } else {
                num += stock.getProductNum();
                stockMapper.update(storeId, id, num);
            }
        }
    }

    @Override
    public boolean sub(Integer storeId, List<SProduct> products) {
        for (SProduct product: products) {
            Integer id = product.getProduct_id();
            Integer num = product.getProduct_num();
            Stock stock = stockMapper.select(storeId, id);
            if(stock == null || stock.getProductNum() < num){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
            num = stock.getProductNum() - num;
            stockMapper.update(storeId, id, num);
        }
        return true;
    }

    @Override
    public List<Store> detail(Integer storeId) {
        return stockMapper.searchStore(storeId);
    }
}
