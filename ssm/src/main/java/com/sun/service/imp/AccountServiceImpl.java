package com.sun.service.imp;

import com.sun.dao.AccountDao;
import com.sun.domain.Account;
import com.sun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm
 * @ClassName AccountServiceImpl
 * @description:
 * @author: lk
 * @create: 2020-04-01 01:36
 * @Version 1.0
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层: 查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层: 添加账户");
        accountDao.save(account);
    }


}
