package com.lzh.company.controller;

import com.lzh.company.pojo.Result;
import com.lzh.company.pojo.Slip;
import com.lzh.company.pojo.request.ProSale;
import com.lzh.company.pojo.response.lSlip;
import com.lzh.company.pojo.response.rSlip;
import com.lzh.company.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    public Result add(@RequestBody ProSale proSale){
        if(!saleService.add(proSale)){
            return Result.error(6);
        }
        return Result.success();
    }

    @PostMapping("/examine")
    public Result examine(@RequestBody Integer user_id, @RequestBody Integer slip_id,@RequestBody Integer state){
        if(!saleService.examine(user_id, slip_id, state)){
            return Result.error(7);
        }
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Integer slip_id){
        saleService.delete(slip_id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<lSlip>> list(Integer state, Integer pageNum, Integer pageSize){
        List<lSlip> lSlips = saleService.list(state, pageNum, pageSize);
        return Result.success(lSlips);
    }

    @GetMapping("/detail")
    public Result<rSlip> detail(@RequestParam Integer slip_id){
        rSlip slip = saleService.detail(slip_id);
        return Result.success(slip);
    }
}
