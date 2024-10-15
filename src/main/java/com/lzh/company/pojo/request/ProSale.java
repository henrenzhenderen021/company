package com.lzh.company.pojo.request;

import lombok.Data;

import java.util.List;

@Data
public class ProSale {
    private Integer user_id;
    private Integer customer_id;
    private Integer store_id;
    private List<SProduct> products;
}
