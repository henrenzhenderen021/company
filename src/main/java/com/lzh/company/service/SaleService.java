package com.lzh.company.service;

import com.lzh.company.pojo.Slip;
import com.lzh.company.pojo.request.ProSale;
import com.lzh.company.pojo.response.lSlip;
import com.lzh.company.pojo.response.rSlip;

import java.util.List;

public interface SaleService {
    boolean add(ProSale proSale);

    boolean examine(Integer userId, Integer slipId, Integer state);

    void delete(Integer slipId);

    rSlip detail(Integer slipId);

    List<lSlip> list(Integer state, Integer pageNum, Integer pageSize);
}
