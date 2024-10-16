package com.lzh.company.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private int id;
    private String customerName;
    private String sex;
    private String telephone;
    private String customerType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
