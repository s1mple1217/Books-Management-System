package com.langxi.dao;

import com.langxi.pojo.Book;
import com.langxi.pojo.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowDao {

    @Insert("insert into borrow (username,bookname,borrowtime) values(#{username},#{bookname},#{borrowtime})")
    public int save(Borrow borrow);

    @Update("update borrow set username = #{username},borrowtime = #{borrowtime},returntime = #{returntime} where bookname = #{bookname}")
    public int update(Borrow borrow);

    @Delete("delete from borrow where id = #{id}")
    public int delete(Integer id);

    @Select("select * from borrow where id = #{id}")
    public Borrow getById(Integer id);

    @Select("select * from borrow")
    public List<Borrow> getAll();

    //@Select("select * from borrow where username = #{username} and returntime is null and bookname = (select bookname from book where state = '不可借阅'")
    @Select("select * from borrow where username = #{username} and returntime is null")
    List<Borrow> getByName(String username);

    @Select("select * from borrow where bookname = #{bookname} and returntime is null")
    Borrow returnBookByBookName(String bookname);
}
