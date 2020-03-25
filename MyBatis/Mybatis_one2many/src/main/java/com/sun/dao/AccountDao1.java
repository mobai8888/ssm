package com.sun.dao;


import com.sun.domain.Account;
import com.sun.domain.AccountUser;
import com.sun.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao1 {
    /**
     * 查询所有用户，同时获取出每个用户下的所有账户信息
     * @return
     */
    List<User> findAll();
    List<Account> findAllAccount();

    List<AccountUser> findAllcount1();
}
