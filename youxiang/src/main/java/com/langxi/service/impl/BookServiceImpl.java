package com.langxi.service.impl;

import com.langxi.dao.BookDao;
import com.langxi.pojo.Book;
import com.langxi.pojo.PageBean;
import com.langxi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getByBookName(String name) {

        return bookDao.getByBookName(name);
    }



    //做分页查询
    @Override
    public PageBean<Book> selectByPage(int currentPage, int pageSize) {
        //计算机开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        List<Book> rows = bookDao.selectByPage(begin, size);

        //计算总记录数
        int totalCount = bookDao.selectTotalCount();

        //封装PageBean对象
        PageBean<Book> pageBean = new PageBean<>();

        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        return pageBean;
    }

    @Override
    public PageBean<Book> selectByPageAndCondition(int currentPage, int pageSize, String name) {
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;
        //获取当前查询信息
        List<Book> rows = bookDao.selectByPageAndCondition(begin, size, name);
        //查询记录总条数
        int totalCount = bookDao.selectTotalCountByCondition(name);

        //封装对象
        PageBean<Book> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }


}
