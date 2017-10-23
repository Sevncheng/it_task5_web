package cn.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeDemo {

    @RequestMapping(value = "/")
    public String demo1(){
        return "/Desk/Home";
    }

    //处理用户登出需求重定向回首页
    @RequestMapping(value = "/Home")
    public String demo2(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("fstudent");
        request.getSession().removeAttribute("time");
        //清空cooik的值
        Cookie cookie = new Cookie("userinfo","");
        Cookie cookie1 = new Cookie("token","");
        cookie.setPath("/");
        cookie1.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return "redirect:/Desk/Home";
    }
}
