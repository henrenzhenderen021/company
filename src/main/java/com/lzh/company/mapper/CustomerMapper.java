package com.lzh.company.mapper;

import com.lzh.company.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Insert("insert into t_customer(customer_name, sex, telephone, customer_type, create_time, update_time) "+
            "values(#{customerName}, #{sex}, #{telephone}, #{customerType}, #{createTime}, #{updateTime})")
    void add(Customer customer);

    @Delete("delete from t_customer where customer_id = #{customerId}")
    void delete(Integer id);

//    @Update("update t_customer set customer_name = #{customerName}, sex = #{sex}, telephone = #{telephone}, customer_type = #{customerType}, update_time = #{updateTime} where customer_id = #{id}")
    @Update({
            "<script>",
            "update t_customer",
            "<set>",
            "<if test='customerName != null'>customer_name = #{customerName},</if>",
            "<if test='sex != null'>sex = #{sex},</if>",
            "<if test='telephone != null'>telephone = #{telephone},</if>",
            "<if test='customerType != null'>customer_type = #{customerType},</if>",
            "<if test='updateTime != null'>update_time = #{updateTime},</if>",
            "</set>",
            "where customer_id = #{customerId}",
            "</script>"
    })
    void update(Customer customer);


    @Select("select * from t_customer")
    List<Customer> list();
}
