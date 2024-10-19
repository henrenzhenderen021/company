package com.lzh.company.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Good {
    private int productId;
    private String productName;
    private String productDesc;
    private int categoryId;
    private double purchasePrice;
    private double retailPrice;
    private double wholesalePrice;
    private String imagePath;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
