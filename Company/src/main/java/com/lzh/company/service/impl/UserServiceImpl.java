package com.lzh.company.service.impl;

import com.lzh.company.mapper.UserMapper;
import com.lzh.company.pojo.User;
import com.lzh.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByAccount(String account) {
        User user = userMapper.selectByAccount(account);
        return user;
    }

    @Override
    public void addNewUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(String account, String newPassword) {
        userMapper.update(account, newPassword);
    }
}
