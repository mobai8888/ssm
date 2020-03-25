package com.sun.dao;

import com.sun.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 账户的持久层接口
 */
@CacheNamespace(blocking = true) //mybatis 基于注解方式实现配置二级缓存
public interface IAccountDao {
    //查询所有账户，采用延迟加载的方式查询账户的所属用户
    @Select("select * from account")
    @Results(id ="accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "user",one=@One(select = "com.sun.dao.IUserDao.findUserById",fetchType = FetchType.LAZY))
    })
    List<Account> findAllAccount();
    //根据用户的id查询该用户下所有的账户信息
    @Select("select * from account where uid=#{uid}")
    List<Account> findByUid(Integer uid);
}
