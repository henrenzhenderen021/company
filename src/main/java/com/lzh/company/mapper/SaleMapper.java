package com.lzh.company.mapper;

import com.lzh.company.pojo.Sale;
import com.lzh.company.pojo.request.SProduct;
import com.lzh.company.pojo.response.lSlip;
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
}
