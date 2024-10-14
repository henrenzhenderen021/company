package com.lzh.company.service;

import com.lzh.company.pojo.Store;
import com.lzh.company.pojo.request.SProduct;

import java.util.List;

public interface StockService {
    void add(Integer storeId, List<SProduct> products);

    boolean sub(Integer storeId, List<SProduct> products);

    List<Store> detail(Integer storeId);
}
