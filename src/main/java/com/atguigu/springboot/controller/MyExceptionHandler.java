package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    //声明处理那种
    @ExceptionHandler(UserException.class)
    public Map handlerException(Exception e, HttpServletRequest request){
        HashMap map=new HashMap();
        map.put("code","不存在");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return map;
    }
}
