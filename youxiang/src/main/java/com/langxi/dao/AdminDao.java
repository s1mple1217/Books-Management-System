package com.langxi.dao;

import com.langxi.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminDao {

  /*  private int id;
    private String username;
    private String bookname;
    private double price;*/
    @Select("select * from admin")
    List<Admin> getAll();

    @Select("select * from admin where id = #{id}")
    Admin getById(int id);

    @Insert("insert into admin(name,password) values(#{name},#{password})")
    int save(Admin admin);

    @Update("update admin set name = #{name},password = #{password}")
    int update(Admin admin);

    @Delete("delete from admin where id = #{id}")
    int delete(Integer id);

    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin login(@Param("name") String name, @Param("password") String password);


}
