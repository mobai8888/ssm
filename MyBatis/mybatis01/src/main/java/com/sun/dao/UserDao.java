package com.sun.dao;

import com.sun.domain.User;

import java.util.List;

public interface UserDao {
    //查询全部成员
    List<User> findAll();
}
