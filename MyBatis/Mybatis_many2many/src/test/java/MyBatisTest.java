import com.sun.dao.RoleDao;
import com.sun.domain.Role;
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
 * @ClassName MyBatisTest
 * @description:
 * @author: lk
 * @create: 2020-01-14 10:33
 * @Version 1.0
 **/
public class MyBatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role:roles){
            System.out.println("---每个角色的信息----");
            System.out.println(role);
            System.out.println(role.getListUser());
        }
    }
    @Test
    public void testFindAllUser(){
        List<User> users = roleDao.findAllUser();
        for (User user:users){
            System.out.println("-----每个用户的信息-----");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

}
