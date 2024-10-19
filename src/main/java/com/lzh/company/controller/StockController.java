package com.lzh.company.controller;

import com.lzh.company.pojo.Store;
import com.lzh.company.pojo.request.ProStock;
import com.lzh.company.pojo.Result;
import com.lzh.company.pojo.request.ProStore;
import com.lzh.company.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public Result add(@RequestBody ProStock proStock){
        stockService.add(proStock.getStore_id(), proStock.getProducts());
        return Result.success();
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody ProStock proStock){
        if(!stockService.sub(proStock.getStore_id(), proStock.getProducts())){
            return Result.error(6);
        }
        return Result.success();
    }

    @GetMapping("/detail")
    public Result<List<Store>> detail(@RequestParam Integer store_id){
        List<Store> stores = stockService.detail(store_id);
        return Result.success(stores);
    }

    @PostMapping("/dispatch")
    public Result dispatch(@RequestBody ProStore proStore){
        if(!stockService.sub(proStore.getStore_id_out(), proStore.getProducts())){
            return Result.error(6);
        }
        stockService.add(proStore.getStore_id_in(), proStore.getProducts());
        return Result.success();
    }
}
