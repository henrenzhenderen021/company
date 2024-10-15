package com.lzh.company.controller;


import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.Result;
import com.lzh.company.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @PostMapping("/add")
    public Result addGood(@RequestBody Good good){
        goodService.addGood(good);
        return Result.success();
    }



}
