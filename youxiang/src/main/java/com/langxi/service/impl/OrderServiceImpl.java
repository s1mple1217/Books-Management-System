package com.langxi.service.impl;

import com.langxi.dao.OrderDao;
import com.langxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean save(OrderDao orderDao) {
        return orderDao.save(orderDao)>0;
    }

    @Override
    public boolean update(OrderDao orderDao) {
        return orderDao.update(orderDao)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return orderDao.delete(id)>0;
    }

    @Override
    public OrderDao getById(Integer id) {
        return orderDao.getById(id);
    }

    @Override
    public List<OrderDao> getAll() {
        return orderDao.getAll();
    }
}
