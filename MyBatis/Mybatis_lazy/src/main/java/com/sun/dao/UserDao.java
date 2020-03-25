package com.sun.dao;

import com.sun.domain.Account;
import com.sun.domain.User;

import java.util.List;

public interface UserDao {
    /*根据用户的id查询用户信息
    * */
    User findUserById(Integer uid);
    //查询所有用户，同时获取出每个用户下的所有账户信息
    List<User> findAllUser();
    /**
     * 根据用户 id 查询账户信息
     * @param uid
     * @return
     */
    List<Account> findByUid(Integer uid);
    //更新用户
    void updateUser(User user);
}
