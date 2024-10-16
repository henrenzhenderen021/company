package com.lzh.company.controller;


import com.lzh.company.pojo.Customer;
import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.PageBean;
import com.lzh.company.pojo.Result;
import com.lzh.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Result add(@RequestBody Customer customer) {
        customerService.add(customer);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id) {
        System.out.println("id is " + id);
        customerService.delete(id);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Customer customer) {
        customerService.update(customer);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<PageBean<Customer>> list(
            Integer pageNum,
            Integer pageSize
    ){
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageBean<Customer> pb = customerService.list(pageNum, pageSize);
        return Result.success(pb);
    }

}
