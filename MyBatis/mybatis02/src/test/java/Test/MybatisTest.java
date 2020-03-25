
package Test;

import com.sun.dao.UserDao;
import com.sun.domin.QueryVo;
import com.sun.domin.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName MybatisTest
 * @description:测试mybatis的crud操作
 * @author: lk
 * @create: 2020-01-13 14:10
 * @Version 1.0
 **/
public class MybatisTest {
        private InputStream in;
        private SqlSession sqlSession;
        private UserDao userDao;
        @Before//用于在测试方法执行之前执行
        public void init() throws IOException {
            //1.读取配置文件，生成字节输入流
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获取SqlSessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3.获取SqlSession对象
            sqlSession = sessionFactory.openSession();
            //4.获取dao的代理对象
            userDao = sqlSession.getMapper(UserDao.class);
        }
        @After//用于在测试方法执行之后执行
        public void destory() throws IOException {
            //提交事务
            sqlSession.commit();
            //6.释放资源
            sqlSession.close();
            in.close();
        }
        /**
         * 测试查询所有
         */
       @Test
       public void testFindAll(){
           //5.执行查询所有方法
           List<User> users = userDao.findAll();
           for (User user:users){
               System.out.println(user);
           }
       }
    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user=new User();
        user.setUserName("测试保存");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前："+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
        }
    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user=new User();
        user.setUserId(3);
        user.setUserName("mybastis update user");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
            userDao.updateUser(user);
        }

        /**
        * 测试删除操作
        */
        @Test
        public void testDelete(){
            //5.执行删除方法
            userDao.deleteUser(3);
        }
        /**
         * 测试根据id查询用户信息
         */
        @Test
        public void testFindOne(){
            User user = userDao.findById(2);
            System.out.println(user);
        }
        /**
         * 测试模糊查询操作
         */
        @Test
        public void testFindByName(){
            List<User> name = userDao.findByName("%张%");
            //List<User> users = userDao.findByName("王");
            System.out.println(name.toString());
        }
        /**
         * 测试查询总记录条数
         */
        @Test
        public void testCount(){
            int total = userDao.findTotal();
            System.out.println(total);
        }
        /**
         * 测试使用QueryVo作为查询条件
         */
        @Test
        public void testFindByVo(){
            QueryVo vo=new QueryVo();
            User u=new User();
            u.setUserName("%三%");
            vo.setUser(u);
            List<User> userByVo = userDao.findUserByVo(vo);
            for (User u1:userByVo){
                System.out.println(u1);
            }
        }

}
