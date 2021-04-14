package cn.gsdx.day01;

import cn.gsdx.day01.dao.UserMapperDynamic;
import cn.gsdx.day01.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JackWen
 */
public class UserDynamicTest {
    public SqlSessionFactory getSqlSessionFactory(String resource) throws IOException {
        InputStream resources = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resources);
        return sqlSessionFactory;
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = new User(1, "张三", "1234", null,null);
        User result = mapper.queryUserByAllInfo(user);
        System.out.println(result);

    }

    @Test
    public void test02 () throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = new User(1, "张三", "1234", null,null);
        User result = mapper.queryUserByTrim(user);
        System.out.println(result);

    }

    @Test
    public void test03 () throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = new User(1, "张三", "1234", null,null);
        User result = mapper.queryUserByChoose(user);
        System.out.println(result);

    }

    @Test
    public void test04 () throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = new User(1, "小红", null, null,null);
        boolean result = mapper.updateUser(user);
        System.out.println(result);

    }

    @Test
    public void test05 () throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);

        List<User> result = mapper.queryUserByForEach(Arrays.asList(1,2,4,5));
        System.out.println(result);
    }

    /*
    * 批量保存
    * */
    @Test
    public void test06 () throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);

        List<User> users = new ArrayList<>();
        users.add(new User(null,"孙悟空","1234",null,null));
        users.add(new User(null,"猪八戒","1234",null,null));
        users.add(new User(null,"沙和尚","1234",null,null));
        users.add(new User(null,"唐僧","1234",null,null));
        boolean b = mapper.addUsers(users);
        System.out.println(b);
    }

    @Test
    public void test07() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = mapper.queryUserTest(5);
        System.out.println(user);
    }

    @Test
    public void test08() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperDynamic mapper = openSession.getMapper(UserMapperDynamic.class);
        User user = mapper.queryUserByLikeName("孙");
        System.out.println(user);
    }
}
