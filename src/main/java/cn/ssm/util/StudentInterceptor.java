package cn.ssm.util;

import cn.ssm.service.StudentService;
import cn.ssm.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class StudentInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private DesUtil desUtil;
    @Autowired
    private StudentService studentService;

    private String paskey="87654321";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean falg = false;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
               if(cookie.getValue()!=null&&cookie.getValue()!=""){
                   desUtil.setKey(paskey);
                   //des解密
                   desUtil.setDesString(cookie.getValue());
                   String temp = desUtil.getStrM();
                   String[] tokenval = temp.split(",");
                   //根据ID判定是否存在
                   if (studentService.findById(tokenval[0]) != null) {
                       falg = true ;
                   }
               }
            }
        }
        if(falg==false){
            response.sendRedirect(request.getContextPath()+"/Desk/errorloginUI");
        }
        return falg;
    }
}
