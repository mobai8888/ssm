

import com.sun.dao.IAccountDao;
import com.sun.dao.IUserDao;
import com.sun.domain.Account;
import com.sun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName MybatisAnnotationCRUDTest
 * @description:
 * @author: lk
 * @create: 2020-01-14 14:28
 * @Version 1.0
 **/
public class MybatisAnnotationCRUDTest {
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAllUser();
        for (User user:users){
            System.out.println(user);
        }
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testFindById() {
       List<Account> accounts = iAccountDao.findByUid(1);
       session.close();
       session=factory.openSession();
       iAccountDao=session.getMapper(IAccountDao.class);
        List<Account> accounts2 = iAccountDao.findByUid(1);
        System.out.println(accounts==accounts2);
    }
    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("mybatis annotation");
        user.setUserSex("男");
        user.setUserAddress("北京市顺义区");
        user.setUserBirthday(new Date());
        int res = userDao.insertUser(user);
        System.out.println("影响数据库记录的行数："+res);
        System.out.println("插入的主键值："+user.getUserId());
    }
    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByUserName("%up%");
        System.out.println(users);
    }
    //测试一对一懒加载
    @Test
    public void testone2oneLazy(){
        List<Account> account = iAccountDao.findAllAccount();

    }
    //测试一对多懒加载
    @Test
    public void testone2ManyLazy(){
        List<User> users = userDao.findAllUser();
        for (User user:users){
            System.out.println(user);
        }

    }

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    IAccountDao iAccountDao;
    @Before//junit 的注解
    public void init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlConfig.xml");
        //2.创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.创建 session
        session = factory.openSession();
        //4.创建代理对象
        userDao = session.getMapper(IUserDao.class);
        iAccountDao = session.getMapper(IAccountDao.class);
    }
    @After//junit 的注解
    public void destroy()throws Exception {
        //提交事务
        session.commit();
        //释放资源
        session.close();
        //关闭流
        in.close();
    }
}

