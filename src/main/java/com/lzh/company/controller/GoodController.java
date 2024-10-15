package com.lzh.company.controller;


import com.lzh.company.pojo.Good;
import com.lzh.company.pojo.PageBean;
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

    @DeleteMapping("/delete")
    public Result deleteGood(Integer id){
        goodService.deleteGood(id);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateGood(@RequestBody Good newGood){
//        System.out.println(newGood);
        goodService.updateGood(newGood);
//        System.out.println(newGood);
        return Result.success();
    }


    @GetMapping("/list")
    public Result<PageBean<Good>> list(
            Integer pageNum,
            Integer pageSize
    ){
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageBean<Good> pb = goodService.list(pageNum, pageSize);
        return Result.success(pb);
    }


}
