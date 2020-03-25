import com.sun.dao.AccountDao1;
import com.sun.domain.Account;
import com.sun.domain.AccountUser;
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
 * @create: 2020-01-13 18:30
 * @Version 1.0
 **/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao1 accountDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao1.class);
    }
    @Test
    public void testFindAll(){

        List<User> users = accountDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindAll1(){

       List<Account> users = accountDao.findAllAccount();
        for(Account user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindAll2(){

        List<AccountUser> accountUsers = accountDao.findAllcount1();
        for(AccountUser user:accountUsers){
            System.out.println(user);
        }
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
