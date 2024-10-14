package com.lzh.company.pojo.request;

import lombok.Data;

import java.util.List;

@Data
public class ProStock {
    private Integer store_id;
    List<SProduct> products;
}
