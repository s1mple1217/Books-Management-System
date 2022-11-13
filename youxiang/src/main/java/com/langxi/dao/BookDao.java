package com.langxi.dao;

import com.langxi.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {
    /*
    * 图书模块
    *
    * */
    @Insert("insert into book (name,author,state,price,type) values(#{name},#{author},#{state},#{price},#{type})")
    public int save(Book book);

    @Update("update book set name = #{name},author = #{author},state = #{state},price = #{price},type = #{type} where id = #{id}")
    public int update(Book book);

    @Delete("delete from book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from book")
    public List<Book> getAll();

    @Select("select * from book where name = #{name}")
    Book getByBookName(String name);




    //分页查询
    @Select("select * from book limit #{begin},#{size}")
    List<Book> selectByPage(@Param("begin") int begin, @Param("size") int size);

    //查询总记录数
    //这里千万不能加@ResultMap("brandResultMap")加了就查不到信息了
    @Select("select count(*) from book")
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from book where name like CONCAT('%',#{name},'%')")
    List<Book> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("name") String name);

    /**
     * 根据条件查询总记录数
     * @return
     */
    @Select("select count(*) from book where name like CONCAT('%',#{name},'%')")
    int selectTotalCountByCondition(String name);




}
