package com.lzh.company.service.impl;

import com.lzh.company.mapper.GoodMapper;
import com.lzh.company.pojo.Good;
import com.lzh.company.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public void addGood(Good good) {
        good.setCreateTime(LocalDateTime.now());
        good.setUpdateTime(LocalDateTime.now());
        goodMapper.addGood(good);
    }
}
