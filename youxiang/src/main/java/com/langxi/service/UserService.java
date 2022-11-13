package com.langxi.service;

import com.langxi.pojo.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    User login(String name,String password);

    User selectByUserName(String name);

    void add(User user);



}
