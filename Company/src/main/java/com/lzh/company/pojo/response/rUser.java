package com.lzh.company.pojo.response;

import com.lzh.company.pojo.enums.UserType;
import lombok.Data;

@Data
public class rUser {
    private Integer userId;
    private String userName;
    private String userType;
}
