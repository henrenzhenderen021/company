package com.lzh.company.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzh.company.pojo.Sale;
import com.lzh.company.pojo.request.SProduct;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;

@Data
public class rSlip {
    private String storeName;
    private List<Sale> products;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp updateTime;
}
