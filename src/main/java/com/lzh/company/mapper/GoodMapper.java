package com.lzh.company.mapper;

import com.lzh.company.pojo.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {



    @Insert("insert into t_product(product_name, product_description, category_id, purchase_price, retail_price, wholesale_price, create_time, update_time)"+
            " values(#{productName}, #{productDesc}, #{categoryId}, #{purchasePrice}, #{retailPrice}, #{wholesalePrice}, #{createTime}, #{updateTime})")
    void addGood(Good good);


    @Delete("delete from t_product where product_id = #{productId}")
    void deleteGood(Integer id);

    @Update("update t_product set product_name = #{productName}, product_description = #{productDesc}, category_id = #{categoryId}, purchase_price = #{purchasePrice}, retail_price = #{retailPrice}, wholesale_price = #{wholesalePrice}, update_time = #{updateTime} where product_id = #{productId}")
    void updateGood(Good newGood);

    @Select("select * from t_product ")
    List<Good> list();
}
