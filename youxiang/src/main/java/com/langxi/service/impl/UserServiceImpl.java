package com.langxi.service.impl;

import com.langxi.dao.UserDao;
import com.langxi.pojo.User;
import com.langxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    @Override
    public User selectByUserName(String name) {
        return userDao.selectByUserName(name);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

}
