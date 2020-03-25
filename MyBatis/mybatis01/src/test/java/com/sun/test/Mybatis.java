package com.sun.test;

import com.sun.dao.UserDao;
import com.sun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName Mybatis测试类
 * @description:
 * @author: lk
 * @create: 2020-01-13 09:51
 * @Version 1.0
 **/
public class Mybatis {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=sqlSessionFactoryBuilder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session=factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user:userList){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
