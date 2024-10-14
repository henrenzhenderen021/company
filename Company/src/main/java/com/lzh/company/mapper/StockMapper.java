package com.lzh.company.mapper;

import com.lzh.company.pojo.Stock;
import com.lzh.company.pojo.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StockMapper {
    @Select("select * from t_stock where store_id = #{storeId} and product_id = #{id}")
    Stock select(Integer storeId, Integer id);
    @Insert("INSERT INTO t_stock VALUES(null, #{storeId}, #{id}, #{num}, now(), now())")
    void insert(Integer storeId, Integer id, Integer num);
    @Update("UPDATE t_stock SET product_num = #{num}, update_time = now() WHERE store_id = #{storeId} and product_id = #{id}")
    void update(Integer storeId, Integer id, Integer num);
    @Select("SELECT product_name, product_num FROM t_stock, t_product WHERE store_id = #{storeId} and t_stock.product_id = t_product.product_id")
    List<Store> searchStore(Integer storeId);
}
