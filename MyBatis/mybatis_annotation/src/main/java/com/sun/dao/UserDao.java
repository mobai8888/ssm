package com.sun.dao;

import com.sun.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //查询全部成员
    @Select("select * from user")
    List<User> findAll();
}
