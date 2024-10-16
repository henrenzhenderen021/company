package com.lzh.company.service;

import com.lzh.company.pojo.Customer;
import com.lzh.company.pojo.PageBean;

public interface CustomerService {
    void add(Customer customer);

    void delete(Integer id);

    void update(Customer customer);

    PageBean<Customer> list(Integer pageNum, Integer pageSize);
}
