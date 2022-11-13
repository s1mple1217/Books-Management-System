package com.langxi.controller;

import com.alibaba.fastjson.JSON;
import com.langxi.pojo.Book;
import com.langxi.pojo.Borrow;
import com.langxi.pojo.PageBean;
import com.langxi.pojo.User;
import com.langxi.service.BookService;
import com.langxi.service.BorrowService;
import com.langxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;
    Borrow borrow;
    Date day;

    //@GetMapping
    /*public Result getAll1(HttpServletRequest request) {
        System.out.println("--------------------");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Book> bookList = bookService.getAll();
        //查询到的有可能是空字符串，所以要判断是不是null
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        //String msg = bookList != null ? "成功" : "数据查询失败！";
        String msg = bookList != null ? user.getName() : "数据查询失败！";
        return new Result(code, bookList, msg);
    }*/

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code;
        if (book != null && "可借".equals(book.getState())) {
            code = Code.GET_OK;
        } else {
            code = Code.GET_ERR;
        }

        //Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        //String msg = book != null ? "成功" : "数据查询失败！";

        return new Result(code, book);
    }

    @GetMapping("/borrow/{id}")
    public Result borrow(@PathVariable String id, HttpServletRequest request) {
        Book book = bookService.getById(Integer.parseInt(id));

        borrow = new Borrow();

        day = new Date(System.currentTimeMillis());

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        borrow.setUsername(user.getName());
        borrow.setBookname(book.getName());
        borrow.setBorrowtime(day);
        //System.out.println(book.toString());
        Integer code;
        if ("可借".equals(book.getState())) {
            borrowService.save(borrow);
            book.setState("不可借阅");
            bookService.update(book);
            code = Code.SAVE_OK;
        } else {
            code = Code.SAVE_ERR;
        }
        return new Result(code, "未知异常");
    }

    @GetMapping("/returnbook/{bookname}")
    public Result returnbook(@PathVariable String bookname, HttpServletRequest request) {
        Integer code;
        day = new Date(System.currentTimeMillis());
        //将书的还书时间添加到borrow表中
        Borrow borrow = borrowService.returnBookByBookName(bookname);
        borrow.setReturntime(day);

        boolean update = borrowService.update(borrow);

        if (update == true) {
            Book book = bookService.getByBookName(bookname);
            book.setState("可借");

            bookService.update(book);

            code = Code.GET_OK;

        } else {
            code = Code.GET_ERR;
        }


        return new Result(code, update);
    }

    @GetMapping("/borrowmsg")
    public Result borrowmsg(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        Integer code;
        //查询returntime为null的数据
        List<Borrow> byName = borrowService.getByName(user.getName());



        if (byName != null) {
            code = Code.GET_OK;
        } else {
            code = Code.GET_ERR;
        }
        return new Result(code, byName, "查询失败，请稍后再试");
    }

    @GetMapping("/page")
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //接受前端发来的页码和每页展示条数 形式：url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //因为前端传来的数据是字符串 所以得转换一下
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Book> pageBean = bookService.selectByPage(currentPage, pageSize);
        pageBean.setName(user.getName());

        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //String name = JSON.toJSONString(user.getName());

        //System.out.println(name);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
        //response.getWriter().write(name);

        /*Integer code = jsonString != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jsonString != null ? user.getName() : "数据查询失败！";*/

        /*return new Result(code, jsonString, msg);*/

    }

    @GetMapping("/conditionQuery")
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        System.out.println(name);


        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");


        PageBean<Book> bookPageBean = bookService.selectByPageAndCondition(currentPage, pageSize, name);
        bookPageBean.setName(user.getName());

        //把查询结果 转为json并传回前端
        String jsonString = JSON.toJSONString(bookPageBean);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
