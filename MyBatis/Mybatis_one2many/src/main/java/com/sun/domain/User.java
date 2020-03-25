package com.sun.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName User
 * @description:
 * @author: lk
 * @create: 2020-01-13 18:51
 * @Version 1.0
 **/
public class User implements Serializable{
    private Integer id;
    private String name;
    private Date birthday;
    private String sex;
    private String address;
    List<Account> list;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", list=" + list +
                '}';
    }
}
