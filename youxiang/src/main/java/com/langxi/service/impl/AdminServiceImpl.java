package com.langxi.service.impl;

import com.langxi.dao.AdminDao;
import com.langxi.pojo.Admin;
import com.langxi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }

    @Override
    public Admin getById(int id) {
        return adminDao.getById(id);
    }

    @Override
    public boolean save(Admin admin) {
        return adminDao.save(admin) > 0;
    }

    @Override
    public boolean update(Admin admin) {
        return adminDao.update(admin) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return adminDao.delete(id) > 0;
    }

    @Override
    public Admin login(String name, String password) {
        return adminDao.login(name,password);
    }
}
