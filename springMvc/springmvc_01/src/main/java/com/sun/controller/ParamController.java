package com.sun.controller;

import com.sun.domain.Account;
import com.sun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: springMvc
 * @ClassName ParamController
 * @description:请求参数绑定
 * @author: lk
 * @create: 2020-03-30 19:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/param")
public class ParamController {
    //请求参数绑定入门
    @RequestMapping("/testParm")
    public String testParam(@RequestParam("username") String name, String password){
        System.out.println("执行了");
        System.out.println("用户名:"+name);
        System.out.println("密码:"+password);
        return "success";
    }
    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }
    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了...");
        System.out.println(user);
        return "success";
    }
    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
