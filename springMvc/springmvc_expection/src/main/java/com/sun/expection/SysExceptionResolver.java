package com.sun.expection;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springMvc
 * @ClassName SysExceptionResolver
 * @description:异常处理器
 * @author: lk
 * @create: 2020-03-31 23:35
 * @Version 1.0
 **/
public class SysExceptionResolver implements HandlerExceptionResolver{

    //处理异常业务逻辑
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取异常信息对象
        SysException e=null;
        if (ex instanceof SysException){
            e=(SysException)ex;
        }else{
            e = new SysException("系统正在维护....");
        }
        // 创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("errors");
        return mv;
    }
}
