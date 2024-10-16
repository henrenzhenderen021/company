package com.lzh.company.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzh.company.mapper.CustomerMapper;
import com.lzh.company.pojo.Customer;
import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.PageBean;
import com.lzh.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void add(Customer customer) {
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());
        customerMapper.add(customer);
    }

    @Override
    public void delete(Integer id) {
        customerMapper.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customer.setUpdateTime(LocalDateTime.now());
        customerMapper.update(customer);
    }

    @Override
    public PageBean<Customer> list(Integer pageNum, Integer pageSize) {
        PageBean<Customer> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Customer> b=customerMapper.list();
        Page<Customer> p=(Page<Customer>) b;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }


}
