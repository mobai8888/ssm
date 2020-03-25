import com.sun.dao.IAccountDao;
import com.sun.domain.Account;
import com.sun.dao.UserDao;
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
import java.util.List;

/**
 * @program: MyBatis
 * @ClassName MybatisTest
 * @description:
 * @author: lk
 * @create: 2020-01-14 11:40
 * @Version 1.0
 **/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;
    private UserDao userDao;
    private SqlSessionFactory factory;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory= new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
        userDao=sqlSession.getMapper(UserDao.class);
    }
   /* 查询所有账户，同时还要获取到当前账户的所属用户信息*/
    @Test
    public void testFindAllAccount(){
        List<Account> accounts = iAccountDao.findAllAccount();
        for (Account account:accounts){
            System.out.println(account.getUser().getName());
        }

    }
    /* 查询所有用户，同时还要获取到当前用户的所属账户信息*/
    @Test
    public void testFindAlluser(){
        List<User> users = userDao.findAllUser();
    }
    @Test
    public void testFindAccountByUid(){
        User user = userDao.findUserById(1);
        System.out.println("第一次查询的用户："+user);
       /* sqlSession.close();
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(UserDao.class);*/
      /*  sqlSession.clearCache();//此方法也可以清空缓存
        userDao = sqlSession.getMapper(UserDao.class);*/
        User user2 = userDao.findUserById(1);
        System.out.println("第二次查询用户："+user2);
        System.out.println(user == user2);
    }
   //测试缓存的同步
    @Test
    public void testClearlCache(){
//1.根据 id 查询用户
        User user1 = userDao.findUserById(1);
        System.out.println(user1);
//2.更新用户信息
        user1.setName("update user clear cache");
        user1.setAddress("北京市海淀区");
        userDao.updateUser(user1);
//3.再次查询 id 为 41 的用户
        User user2 = userDao.findUserById(1);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        UserDao dao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = dao1.findUserById(1);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失
        SqlSession sqlSession2 = factory.openSession();
        UserDao dao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = dao2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println(user1 == user2);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
