package com.lzh.company.service;

import com.lzh.company.pojo.User;

public interface UserService {
    User selectByAccount(String account);

    void addNewUser(User user);

    void update(String account, String newPassword);
}
