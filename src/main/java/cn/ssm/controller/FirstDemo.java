package cn.ssm.controller;

import cn.ssm.entity.Student;
import cn.ssm.service.StudentService;
import cn.ssm.util.AppMD5Util;
import cn.ssm.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping(value = "/Desk")
public class FirstDemo {

    @Autowired
    public StudentService studentService;
    @Autowired
    public DesUtil desUtil;

    private String paskey="87654321";

    //跳转主页
    @RequestMapping(value = "/Home")
    public String homeUI(Model model,HttpServletRequest request,HttpServletResponse response) {
        Cookie cookie1 = null;
        //判断是否处于已登录状态
        if (request.getSession().getAttribute("fstudent") == null) {
            //判定为非登录状态进行自动登录
            //这样便可以获取一个cookie数组
            try {
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userinfo")) {
                        //对cookies数组中的原存放值进行解码取值
                        String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        String[] info = str.split(",");
                        Student st = new Student();
                        st.setName(info[0]);
                        //因为存放时用的是已经MD5加密过的所以取出时直接拿就行了
                        st.setPassword(info[1]);
                        Student newst = studentService.findByStudent(st);
                        if (newst != null) {
                            //验证登录成功后,将temp放入session域中,并跳转到首页
                            request.getSession().setAttribute("fstudent", newst);
                            Date timedate = new Date();
                            //生成token令牌
                            String val = newst.getId()+","+timedate.getTime();
                            //进行加密处理
                            desUtil.setKey(paskey);
                            desUtil.setEncString(val);
                            cookie1 = new Cookie("token",desUtil.getStrMi());
                            cookie1.setPath("/");
                            //token令牌有效时间为
                            cookie1.setMaxAge(100);
                            request.getSession().setAttribute("time", timedate);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("自动登录失败");
            }
        }
        model.addAttribute("nub1", studentService.findByStates("已就业"));
        model.addAttribute("nub2", studentService.findByStates("学习中"));
        if (cookie1!=null){
            response.addCookie(cookie1);
        }
        return "home.page";
    }

    //跳转3号页面
    @RequestMapping(value = "/Three")
    public String threeUI(){
        return "three.page";
    }

    //跳转到注册页面
    @RequestMapping(value = "/addUI")
    public String addUI(){
        return "/WEB-INF/addUI.jsp";
    }

    //跳转到登录页面
    @RequestMapping(value = "/loginUI")
    public String loginUI(){
        return "/WEB-INF/loginUI.jsp";
    }


    //用户未登录跳转到错误提示登录页面
    @RequestMapping(value = "/errorloginUI")
    public String errorloginUI(){
        return "/WEB-INF/errorloginUI.jsp";
    }


    //处理登录请求成功后重定向到首页否则跳回登录页面
    @RequestMapping(value = "/desk",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Student student, HttpServletResponse response){
        String str = "/Desk/loginUI";
        try {
            //对密码进行加密处理后与数据库对比
            String pwd = student.getPassword();
            student.setPassword(AppMD5Util.getMD5(pwd));
            Student temp = studentService.findByStudent(student);
            if (temp!=null) {
                //对用户信息进行编码
                String info =  URLEncoder.encode(student.getName()+","+AppMD5Util.getMD5(pwd),"UTF-8");
                //将用户名称和密码存入cookie
                Cookie cookie = new Cookie("userinfo",info);
                cookie.setMaxAge(24*60*60);
                cookie.setPath("/");
                response.addCookie(cookie);
                //验证登录成功后,将temp放入session域中,并跳转到首页
                request.getSession().setAttribute("fstudent",temp);
                Date timedate = new Date();
                //生成token令牌
                String val = temp.getId()+","+timedate.getTime();
                System.out.println(val);
                //进行加密处理
                desUtil.setKey(paskey);
                desUtil.setEncString(val);
                Cookie cookie1 = new Cookie("token",desUtil.getStrMi());
                cookie1.setPath("/");
                //token令牌有效时间为
                cookie1.setMaxAge(100);
                response.addCookie(cookie1);
                request.getSession().setAttribute("time",timedate);
                str = "redirect:/Desk/Home";
            }
        }catch (Exception e){}
        //登录失败跳回登录方法
        return str;
    }


    //处理注册请求后重定向至首页
    @RequestMapping(value = "/Student",method = RequestMethod.POST)
    public String addStudent(Student student){
        String url = "/Desk/loginUI";
        if (student!=null){
            //为帐号添加唯一uuid
            UUID uu  =  UUID.randomUUID();
            String id = uu.toString().replace("-","");
            student.setId(id);
            //注册时默认学习状态为在学状态
            student.setStates("学习中");
            Long ctime = new Date().getTime();
            //将密码进行加密存储
            String pwd = student.getPassword();
            student.setPassword(AppMD5Util.getMD5(pwd));
            student.setCreatetime(ctime);
            studentService.add(student);
            //注册成功,重定向到首页
            url = "redirect:/Desk/Home";
        }
        return url;
    }

    //获取所有用户并跳转至列表页面
    @RequestMapping(value = "/Student",method = RequestMethod.GET)
    public String listStudent(Model model, HttpServletRequest request) throws ServletException, IOException {
        List<Student> list = studentService.findAll();
        model.addAttribute("studentlist",list);
        return "/WEB-INF/listUI.jsp";
    }


    //处理跳转至更新页面请求
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.GET)
    public String updateUI(Model model,@PathVariable("id") String id){
       Student student = studentService.findById(id);
       model.addAttribute("studentup",student);
       return "/WEB-INF/updateUI.jsp";
    }

    //处理更新请求并跳转至列表页面方法
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.PUT)
    public String updateStudent(Model model,Student student){
       studentService.update(student);
       return "redirect:/Desk/Student";
    }

    //处理删除用户请求并跳回列表页面方法
    @RequestMapping(value = "/Student/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("id") String id){
        Student student = studentService.findById(id);
        studentService.delete(student);
        return "redirect:/Desk/Student";
    }
}
