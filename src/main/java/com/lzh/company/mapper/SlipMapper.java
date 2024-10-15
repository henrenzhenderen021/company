package com.lzh.company.mapper;

import com.lzh.company.pojo.Slip;
import com.lzh.company.pojo.response.lSlip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SlipMapper {
    @Insert("INSERT INTO t_slip VALUES(null, #{customerId}, #{storeId}, #{userId}, 1, 'admit', now(), now())")
    public void insert(Integer customerId, Integer storeId, Integer userId);
    @Select("SELECT count(*) FROM t_slip")
    public Integer count();
    @Update("UPDATE t_slip SET examine_user_id = #{userId}, state = #{state}, update_time = now() WHERE slip_id = #{slipId}")
    void setStatus(Integer slipId, Integer userId, String state);
    @Select("SELECT store_id FROM t_slip WHERE slip_id = #{slipId}")
    Integer getStore(Integer slipId);
    @Update("UPDATE t_slip SET state = #{state}, update_time = now() WHERE slip_id = #{slipId}")
    void setOnlyStatus(Integer slipId, String state);
    @Select("SELECT store_name, create_time, update_time FROM t_slip, t_store WHERE slip_id = #{slipId} and t_slip.store_id = t_store.store_id")
    Slip getDetail(Integer slipId);
    @Select("SELECT slip_id, store_name, customer_name, telephone, t_slip.create_time as create_time, t_slip.update_time as update_time FROM t_slip, t_store, t_customer"
            + " WHERE state = #{state} and t_slip.store_id = t_store.store_id and t_slip.customer_id = t_customer.customer_id")
    List<lSlip> selectByState(String state);
}
