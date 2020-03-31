package com.sun.converter;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springMvc
 * @ClassName StringToDateConverter
 * @description: 把字符串转换日期
 * @author: lk
 * @create: 2020-03-31 02:47
 * @Version 1.0
 **/
public class StringToDateConverter implements Converter<String,Date> {

    //传入进来字符串
    @Override
    public Date convert(String source) {
        System.out.println("ddd");
        if(source==null){
            throw new RuntimeException("请输入数据");
        }
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字符串转换日期
           return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
