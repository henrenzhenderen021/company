package com.lzh.company.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Stock {
    private Integer stockId;
    private Integer storeId;
    private Integer productId;
    private Integer productNum;
    private Timestamp createTime;
    private Timestamp updateTime;
}
