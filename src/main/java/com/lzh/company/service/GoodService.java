package com.lzh.company.service;
import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.PageBean;

public interface GoodService {

    void addGood(Good good);

    void deleteGood(Integer id);

    void updateGood(Good newGood);

    PageBean<Good> list(Integer pageNum, Integer pageSize);
}
