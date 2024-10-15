package com.lzh.company.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Good {
    private int id;
    private String productName;
    private String productDesc;
    private int categoryId;
    private double purchasePrice;
    private double retailPrice;
    private double wholesalePrice;
    private String imagePath;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
