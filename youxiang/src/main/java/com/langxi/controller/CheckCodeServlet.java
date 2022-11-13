package com.langxi.controller;

import com.langxi.util.CheckCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/checkCodeServlet")
public class CheckCodeServlet {

    @GetMapping
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        ServletOutputStream fos = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);


        //存入Session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);

    }
}
