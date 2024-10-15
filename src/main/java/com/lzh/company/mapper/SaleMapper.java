package com.lzh.company.mapper;

import com.lzh.company.pojo.Sale;
import com.lzh.company.pojo.request.SProduct;
import com.lzh.company.pojo.response.lSlip;
import com.lzh.company.pojo.response.rSale;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleMapper {
    @Insert("INSERT INTO t_sale VALUES (null, #{slipId}, #{productId}, #{productNum})")
    void insert(Integer slipId, Integer productId, Integer productNum);
    @Select("SELECT product_id, sale_num FROM t_sale WHERE slip_id = #{slipId}")
    List<Sale> getProduct(Integer slipId);
    @Select("SELECT product_name, sale_num FROM t_sale, t_product WHERE slip_id = #{slipId} and t_sale.product_id = t_product.product_id")
    List<rSale> getProductPlus(Integer slipId);
}
