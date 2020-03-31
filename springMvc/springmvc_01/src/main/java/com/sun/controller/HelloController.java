package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMvc
 * @ClassName HelloController
 * @description:控制器
 * @author: lk
 * @create: 2020-03-29 18:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class HelloController {
    //接收请求
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springmvc!");
        return "success";
    }

    @RequestMapping(value="/testRequestMapping",params = {"username=heihei"},headers = "Accept")
    public String testRequestMapping(){
        System.out.println("测试testRequestMapping");
        return "success";
    }
}
