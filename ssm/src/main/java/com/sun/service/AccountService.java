package com.sun.service;

import com.sun.domain.Account;

import java.util.List;

public interface AccountService {
    //查看所有的账户
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}
