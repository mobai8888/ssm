package com.sun.dao;

import com.sun.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    /**
     * 保存
     * @param account
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void save(Account account);
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();
}
