package com.langxi.controller;

import com.langxi.pojo.Admin;
import com.langxi.pojo.User;
import com.langxi.service.AdminService;
import com.langxi.service.UserService;
import com.langxi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public void toadmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

        Admin admin = adminService.login(name, password);

        if (admin != null) {
            System.out.println("登入成功");

            //如果用户勾选记住我
            if ("1".equals(remember)) {

                System.out.println("-------------------------------");
                //勾选了，发送cookie

                //1.创建cookie对象
                Cookie c_name = new Cookie("name", name);
                Cookie c_password = new Cookie("password", password);

                //设置Cookie的存活时间
                c_name.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);


                c_name.setPath(request.getContextPath());
                c_password.setPath(request.getContextPath());

                //2.发送
                response.addCookie(c_name);
                response.addCookie(c_password);


            }


            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/pages/books.html");

        } else {
            System.out.println("登入失败");

            request.setAttribute("err", "账号或密码错误");
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);

        }


    }

    @GetMapping("/user")
    public void touser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = userService.login(name, password);

        if (user != null) {
            System.out.println("登入成功");

            if ("1".equals(remember)) {

                System.out.println("-------------------------------");
                //勾选了，发送cookie

                //1.创建cookie对象
                Cookie username = new Cookie("username", name);
                Cookie userpassword = new Cookie("userpassword", password);

                //设置Cookie的存活时间
                username.setMaxAge(60 * 60 * 24 * 7);
                userpassword.setMaxAge(60 * 60 * 24 * 7);


                username.setPath(request.getContextPath());
                userpassword.setPath(request.getContextPath());

                //2.发送
                response.addCookie(username);
                response.addCookie(userpassword);


            }


            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/pages/books1.html");

        } else {
            System.out.println("登入失败");

            request.setAttribute("err", "账号或密码错误");
            request.getRequestDispatcher("/pages/user.jsp").forward(request, response);

        }

    }

    @PostMapping("/register")
    public void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        //获取用户输入的验证码值
        String checkCode = request.getParameter("checkCode");

        //获取系统程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = String.valueOf(session.getAttribute("checkCodeGen"));

        //在用户注册之前完成比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误！");
            request.getRequestDispatcher("/pages/register.jsp").forward(request,response);


            //不允许注册
            //直接return后面的代码将不会在被执行。
            return;
        }

        User user1 = userService.selectByUserName(user.getName());

        System.out.println(user1);

        if (user1 == null){
            userService.add(user);
            //注册成功
            //request.setAttribute("register_msg","注册成功请登入");

           // request.getRequestDispatcher("/pages/login.jsp").forward(request,response);

            session.setAttribute("register_msg", "注册成功请登入");
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/pages/user.jsp");
        }else {
            //注册失败
            //request.setAttribute("register_msg","注册失败，用户名已存在");

            //request.getRequestDispatcher("/pages/register.jsp").forward(request,response);

            session.setAttribute("register_msg", "注册失败，用户名已存在");
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/pages/user.jsp");
        }

    }
}
