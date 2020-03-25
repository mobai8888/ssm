package com.sun.dao;

import com.sun.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "name",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "id",property ="accounts",many = @Many(select = "com.sun.dao.IAccountDao.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAllUser();
    //根据 id 查询一个用户
    @Select("select * from user where id=#{uid}")
    @ResultMap("userMap")
    User findUserById(Integer uid);
    //添加一条用户信息(返回主键)
    @Insert("insert into user(name,sex,birthday,address) values(#{userName},#{userSex},#{userBirthday},#{userAddress})")
    @SelectKey(keyColumn = "id",keyProperty = "userId",resultType =Integer.class,before = false,statement ={"select last_insert_id()"})
    int insertUser(User user);
    //更新一条语句
    @Update("update user set name=#{userName},sex=#{userSex},address=#{userAddress},birthday=#{userBirthday}")
    int updateUser(User user);
    //删除一条语句
    @Delete("delete * from user where id=#{uid}")
    int deleteUser(Integer uid);
    //使用聚合函数
    @Select("select (id) from user")
    int findTotal();
    //模糊查询
    @Select("select * from user where name like #{userName}")
    @ResultMap(value = {"userMap"})
    List<User> findByUserName(String name);

    //

}
