package com.sun.domain;

import java.io.Serializable;

/**
 * @program: MyBatis
 * @ClassName AccountUser
 * @description:
 * @author: lk
 * @create: 2020-01-13 18:22
 * @Version 1.0
 **/
public class AccountUser  implements Serializable{

    private String userName;
    private String address;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +"AccountUser{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
