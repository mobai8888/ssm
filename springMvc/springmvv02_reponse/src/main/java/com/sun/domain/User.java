package com.sun.domain;

import java.io.Serializable;

/**
 * @program: springMvc
 * @ClassName User
 * @description:
 * @author: lk
 * @create: 2020-03-31 15:47
 * @Version 1.0
 **/
public class User implements Serializable{
    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
