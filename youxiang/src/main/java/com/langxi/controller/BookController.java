package com.langxi.controller;

import com.alibaba.fastjson.JSON;
import com.langxi.pojo.Admin;
import com.langxi.pojo.Book;
import com.langxi.pojo.PageBean;
import com.langxi.pojo.User;
import com.langxi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK:Code.GET_ERR;
        String msg = book != null ? "成功" : "数据查询失败！";
        return new Result(code,book,msg);
    }

    /*@GetMapping()
    public Result getAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");

        List<Book> bookList = bookService.getAll();
        //查询到的有可能是空字符串，所以要判断是不是null
        Integer code = bookList != null ? Code.GET_OK:Code.GET_ERR;
        //String msg = bookList != null ? "成功" : "数据查询失败！";
        String msg = bookList != null ? admin.getName() : "数据查询失败！";
        return new Result(code,bookList,msg);
    }*/


    @GetMapping("/page")
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //接受前端发来的页码和每页展示条数 形式：url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        //因为前端传来的数据是字符串 所以得转换一下
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Book> pageBean = bookService.selectByPage(currentPage, pageSize);
        pageBean.setName(admin.getName());

        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //String name = JSON.toJSONString(user.getName());

        //System.out.println(name);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    @GetMapping("/conditionQuery")
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        /*//获取查询的对象 json字符串
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        System.out.println(params);
        //转为Book对象
        Book book = JSON.parseObject(params, Book.class);*/

        PageBean<Book> bookPageBean = bookService.selectByPageAndCondition(currentPage, pageSize, name);
        bookPageBean.setName(admin.getName());

        //把查询结果 转为json并传回前端
        String jsonString = JSON.toJSONString(bookPageBean);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}
