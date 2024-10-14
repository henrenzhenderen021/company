package com.lzh.company.mapper;

import com.lzh.company.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE user_account = #{account}")
    User selectByAccount(String account);
    @Insert("INSERT INTO t_user VALUES(null, #{userAccount}, #{userPassword}, #{userName}, #{sex}, #{telephone}, #{userType}, now(), now())")
    void insert(User user);
    @Update("UPDATE t_user SET user_password = #{newPassword}, update_time = now() WHERE user_account = #{account}")
    void update(String account, String newPassword);
}
