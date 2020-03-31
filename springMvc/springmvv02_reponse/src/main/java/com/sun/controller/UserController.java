package com.sun.controller;

import com.sun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: springMvc
 * @ClassName UserController
 * @description:
 * @author: lk
 * @create: 2020-03-31 15:48
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    //返回String
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString......");
        //模拟从数据库中查询出user对象
        User user=new User();
        user.setUsername("小李");
        user.setPassword("123456");
        user.setAge(30);
        //model对象
        model.addAttribute("user",user);
        return "success";
    }
    /**
     * 是void
     * 请求转发一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid......");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //设置中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return ;
    }
    //testModelAndView
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建对象testModelAndView
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("testModelAndView......");
        //模拟数据库数据
        User u=new User();
        u.setUsername("张三");
        u.setPassword("111");
        u.setAge(15);
        // 把user对象存储到mv对象中，也会把user对象存入到request对象
        modelAndView.addObject("user",u);
        //调到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }
    //testForwardOrRedirect使用关键字的方式进行转发或者重定向
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect.....");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }
    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    @ResponseBody
   public User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
   }
}
