package cn.ssm.controller;

import cn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/u")
public class VerificationDemo {

    @Autowired
    public StudentService studentService;


    //跳转2号页面
    @RequestMapping(value = "/Two")
    public String twoUI(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("tp1", studentService.findByType("前端开发"));
        model.addAttribute("tp2", studentService.findByType("后端开发"));
        return  "two.page";
    }
}
