package com.sun.test;

import com.sun.dao.UserDao;
import com.sun.domain.QueryVo;
import com.sun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName MybatisTest
 * @description:
 * @author: lk
 * @create: 2020-01-13 16:44
 * @Version 1.0
 **/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(in);
         sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void testFindByUser(){
        User user=new User();
        user.setUserName("%大%");
        user.setUserAddress("%上地%");
        List<User> users = userDao.findByUser(user);
        for(User user1:users){
            System.out.println(user1);
        }
    }
    @Test
    public void testFindById(){

        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUserName("%四%");
        List<Integer> ids=new ArrayList<>();
        ids.add(2);
        ids.add(5);
        vo.setIds(ids);
        vo.setUser(user);
        List<User> users = userDao.findById(vo);
        for(User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindByIds(){
        User user = userDao.findByIds(2);
        System.out.println(user);
    }

    @After
    public void deStory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
