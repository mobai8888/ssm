package com.sun.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName User
 * @description:
 * @author: lk
 * @create: 2020-01-14 11:14
 * @Version 1.0
 **/
public class User implements Serializable{
    private Integer id;
    private String name;
    private String address;
    private String sex;
    private Date birthday;

    //一对多关系映射：主表实体应该包含从表实体的集合引用
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
