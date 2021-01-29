package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 用于登陆的控制器
 *
 */
@Controller
public class LoginController {

    /**
     * 用于处理用户的登陆请求
     * @param username
     * @param password
     * @param map
     * @return
     */
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HashMap<String,Object> map, HttpSession session){

        //判断
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户密码错误");
            return "login";
        }

    }
}
