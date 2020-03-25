package com.sun.dao;

import com.sun.domain.QueryVo;
import com.sun.domain.User;

import java.util.List;

/**
 * @program: MyBatis
 * @ClassName UserDao
 * @description:
 * @author: lk
 * @create: 2020-01-13 16:30
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 根据用户信息，查询用户列表
     * @param user
     * @return
     */
    List<User> findByUser(User user);
    /**
     * 根据 id 集合查询用户
     * @param queryVo
     * @return
     */
    List<User> findById(QueryVo queryVo);
    /**
     * 根据 id 集合查询用户
     * @param
     * @return
     */
    User findByIds(Integer id);
}
