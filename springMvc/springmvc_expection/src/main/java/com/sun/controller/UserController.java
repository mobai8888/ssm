package com.sun.controller;

import com.sun.expection.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springMvc
 * @ClassName UserController
 * @description:
 * @author: lk
 * @create: 2020-03-31 23:22
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testExpection")
    public String testExpection() throws SysException {
        System.out.println("testExpection...");
        //模拟异常
        try {
            int a=10/0;
        } catch (Exception e) {
            //打印异常
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现错误了...");
        }
        return "success";
    }

}
