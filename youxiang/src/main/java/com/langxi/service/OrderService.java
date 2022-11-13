package com.langxi.service;

import com.langxi.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderService {

    public boolean save(OrderDao orderDao);

    public boolean update(OrderDao orderDao);

    public boolean delete(Integer id);

    public OrderDao getById(Integer id);

    public List<OrderDao> getAll();


}
