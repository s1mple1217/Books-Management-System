package com.langxi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderDao {

    @Insert("insert into order (username,bookname,price) values(#{username},#{bookname},#{price})")
    public int save(OrderDao orderDao);

    @Update("update order set username = #{username},bookname = #{bookname},price = #{price} where id = #{id}")
    public int update(OrderDao orderDao);

    @Delete("delete from order where id = #{id}")
    public int delete(Integer id);

    @Select("select * from order where id = #{id}")
    public OrderDao getById(Integer id);

    @Select("select * from order")
    public List<OrderDao> getAll();

}
