package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMvc
 * @ClassName UserController
 * @description:
 * @author: lk
 * @create: 2020-04-01 00:06
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor...执行了");
        return "success";
    }

}
