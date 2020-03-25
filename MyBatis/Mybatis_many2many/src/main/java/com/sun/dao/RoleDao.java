package com.sun.dao;

import com.sun.domain.Role;
import com.sun.domain.User;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();
}
