package com.langxi.service.impl;

import com.langxi.dao.BorrowDao;
import com.langxi.pojo.Borrow;
import com.langxi.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;

    @Override
    public boolean save(Borrow borrow) {
        return borrowDao.save(borrow) > 0;
    }

    @Override
    public boolean update(Borrow borrow) {
        return borrowDao.update(borrow) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return borrowDao.delete(id) > 0;
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowDao.getById(id);
    }

    @Override
    public List<Borrow> getAll() {
        return borrowDao.getAll();
    }

    @Override
    public List<Borrow> getByName(String username) {
        return borrowDao.getByName(username);
    }

    @Override
    public Borrow returnBookByBookName(String bookname) {

        return borrowDao.returnBookByBookName(bookname);
    }
}
