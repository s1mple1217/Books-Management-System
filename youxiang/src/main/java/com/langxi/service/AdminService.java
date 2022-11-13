package com.langxi.service;

import com.langxi.pojo.Admin;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface AdminService {


    List<Admin> getAll();

    Admin getById(int id);

    boolean save(Admin admin);

    boolean update(Admin admin);

    boolean delete(Integer id);

    Admin login(String name,String password);

}
