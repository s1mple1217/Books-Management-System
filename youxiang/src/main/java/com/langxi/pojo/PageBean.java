package com.langxi.pojo;

import java.util.List;

//分页查询的JavaBean
/*
　JavaBean是一个遵循特定写法的Java类，它通常具有如下特点：

    这个Java类必须具有一个无参的构造函数
    属性必须私有化。
    私有化的属性必须通过public类型的方法暴露给其它程序，并且方法的命名也必须遵守一定的命名规范。
 */
//自定义泛型
public class PageBean<T> {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> rows;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
