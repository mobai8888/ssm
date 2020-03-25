package com.sun.test;


import com.sun.dao.UserDao;
import com.sun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName MybatisTest
 * @description:
 * @author: lk
 * @create: 2020-01-13 11:01
 * @Version 1.0
 **/
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory=sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession=sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User u:all){
            System.out.println(u);
        }
        sqlSession.close();
        in.close();
    }
}
