package com.sun.dao;

import com.sun.domin.QueryVo;
import com.sun.domin.User;

import java.util.List;

/**
 * @program: MyBatis
 * @ClassName UserDao
 * @description:
 * @author: lk
 * @create: 2020-01-13 12:55
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);
    /**
     * 根据Id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);
    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);
    /**
     * 查询总用户数
     * @return
     */
    int findTotal();
    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
