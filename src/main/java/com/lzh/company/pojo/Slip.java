package com.lzh.company.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzh.company.pojo.request.SProduct;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Slip {
    private String storeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp updateTime;
}
