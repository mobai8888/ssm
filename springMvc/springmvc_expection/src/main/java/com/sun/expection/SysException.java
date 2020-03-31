package com.sun.expection;

/**
 * @program: springMvc
 * @ClassName SysException
 * @description:自定义异常类
 * @author: lk
 * @create: 2020-03-31 23:34
 * @Version 1.0
 **/
public class SysException extends Exception{
    //存储提示信息
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
