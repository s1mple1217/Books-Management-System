package com.langxi.service;

import com.langxi.pojo.Book;
import com.langxi.pojo.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//提供业务层接口
@Transactional//事务标记
public interface BookService {
    /**
     * 保存
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Book getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Book> getAll();

    Book getByBookName(String name);


    /**
     * 做分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Book> selectByPage(int currentPage, int pageSize);


    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param name
     * @return
     */
    PageBean<Book>  selectByPageAndCondition(int currentPage,int pageSize,String name);



}