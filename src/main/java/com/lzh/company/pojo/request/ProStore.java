package com.lzh.company.pojo.request;

import lombok.Data;

import java.util.List;

@Data
public class ProStore {
    private Integer store_id_out;
    private Integer store_id_in;
    private List<SProduct> products;
}
