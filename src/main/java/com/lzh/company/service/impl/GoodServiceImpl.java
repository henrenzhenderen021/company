package com.lzh.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzh.company.mapper.GoodMapper;
import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.PageBean;
import com.lzh.company.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public void addGood(Good good) {
        good.setCreateTime(LocalDateTime.now());
        good.setUpdateTime(LocalDateTime.now());
        goodMapper.addGood(good);
    }

    @Override
    public void deleteGood(Integer id) {
        goodMapper.deleteGood(id);
    }

    @Override
    public void updateGood(Good newGood) {
        newGood.setUpdateTime(LocalDateTime.now());
        goodMapper.updateGood(newGood);
    }

    @Override
    public PageBean<Good> list(Integer pageNum, Integer pageSize) {
        PageBean<Good> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Good> b=goodMapper.list();
        Page<Good> p=(Page<Good>) b;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
