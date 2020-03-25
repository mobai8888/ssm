package com.sun.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName Account
 * @description:
 * @author: lk
 * @create: 2020-01-13 18:07
 * @Version 1.0
 **/
public class Account implements Serializable{
    private Integer id;
    private Integer uid;
    private Double money;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
