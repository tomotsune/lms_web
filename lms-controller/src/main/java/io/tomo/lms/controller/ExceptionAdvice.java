package io.tomo.lms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常通知, 处理全局异常
 */
@ControllerAdvice
public class ExceptionAdvice {
/*    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(Exception e){
        System.out.println("警告, 程序出现异常, 发短信"+e.getMessage());
        return "error/5xx";
    }
    @ExceptionHandler(Exception.class)
    public String exception(Exception e){
        System.out.println("警告, 程序出现异常, 发短信"+e.getMessage());
        return "error/5xx";
    }*/
}
