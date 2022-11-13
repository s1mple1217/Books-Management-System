package com.langxi.controller;


import com.langxi.exception.BusinessException;
import com.langxi.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//代表着是REST风格处理controller的
@RestControllerAdvice//这个一定要让springMvcConfig配置类去扫描到
public class ProjectExceptionAdvice {

    //系统异常
    //异常处理器
    @ExceptionHandler(SystemException.class)//选择处理异常的种类
    //参数表示收到的异常，从方法体里面去解决
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    //业务异常
    //异常处理器
    @ExceptionHandler(BusinessException.class)//选择处理异常的种类
    //参数表示收到的异常，从方法体里面去解决
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    //第三种异常
    //异常处理器
    /*@ExceptionHandler(Exception.class)//选择处理异常的种类
    //参数表示收到的异常，从方法体里面去解决
    public Result doException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙！请稍后再试！");
    }*/
}
