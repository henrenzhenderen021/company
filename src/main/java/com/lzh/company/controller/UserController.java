package com.lzh.company.controller;

import com.lzh.company.pojo.Result;
import com.lzh.company.pojo.User;
import com.lzh.company.pojo.response.rUser;
import com.lzh.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<rUser> login(@RequestBody String account,@RequestBody String password){
        User user = userService.selectByAccount(account);
        if(user == null){
            return Result.error(1);
        }
        if(!password.equals(user.getUserPassword())){
            return Result.error(2);
        }
        rUser user1 = new rUser();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setUserType(user.getUserType());
        return Result.success(user1);
    }

    @PostMapping("/register")
    public Result register(@RequestBody String account, @RequestBody String password, @RequestBody String username,
                           @RequestBody String sex, @RequestBody String user_phone, @RequestBody String user_type){
        User user = userService.selectByAccount(account);
        if(user != null){
            return Result.error(3);
        }
        user = new User();
        user.setUserAccount(account);
        user.setUserPassword(password);
        user.setUserName(username);
        user.setSex(sex);
        user.setTelephone(user_phone);
        user.setUserType(user_type);
        userService.addNewUser(user);
        return Result.success();
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody String account, @RequestBody String password, @RequestBody String new_password){
        User user = userService.selectByAccount(account);
        if(user == null){
            return Result.error(1);
        }
        if(!password.equals(user.getUserPassword())){
            return Result.error(4);
        }
        if(password.equals(new_password)){
            return Result.error(5);
        }
        userService.update(account, new_password);
        return Result.success();
    }
}
