package com.lzh.company.pojo;

import com.lzh.company.pojo.enums.Sex;
import com.lzh.company.pojo.enums.UserType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Integer userId;
    private String userAccount;
    private String userPassword;
    private String userName;
    private String sex;
    private String telephone;
    private String userType;
    private Timestamp createTime;
    private Timestamp updateTime;
}
