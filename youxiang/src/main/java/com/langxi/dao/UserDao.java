package com.langxi.dao;

import com.langxi.pojo.Admin;
import com.langxi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface UserDao {
    @Select("select * from user where name = #{name} and password = #{password}")
    User login(@Param("name") String name, @Param("password") String password);

    @Select("select * from user where name = #{name}")
    User selectByUserName(String name);

    @Insert("insert into user (name,password) values(#{name},#{password})")
    void add(User user);

}
