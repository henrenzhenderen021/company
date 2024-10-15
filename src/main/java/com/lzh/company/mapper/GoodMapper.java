package com.lzh.company.mapper;

import com.lzh.company.pojo.Good;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodMapper {

    @Insert("insert into t_product(product_name, product_description, category_id, purchase_price, retail_price, wholesale_price, create_time, update_time)"+
            " values(#{productName}, #{productDesc}, #{categoryId}, #{purchasePrice}, #{retailPrice}, #{wholesalePrice}, #{createTime}, #{updateTime})")
    void addGood(Good good);
}
