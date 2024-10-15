package com.lzh.company.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzh.company.pojo.Sale;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;

@Data
public class rSlip {
    private String storeName;
    private List<rSale> products;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;
}
