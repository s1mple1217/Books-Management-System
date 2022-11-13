package com.langxi.service;

import com.langxi.pojo.Borrow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BorrowService {

    public boolean save(Borrow borrow);

    public boolean update(Borrow borrow);

    public boolean delete(Integer id);

    public Borrow getById(Integer id);

    public List<Borrow> getAll();

    List<Borrow> getByName(String username);

    Borrow returnBookByBookName(String bookname);


}
