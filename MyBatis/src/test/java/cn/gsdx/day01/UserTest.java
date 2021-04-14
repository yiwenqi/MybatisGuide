package cn.gsdx.day01;

import cn.gsdx.day01.dao.UserMapper;
import cn.gsdx.day01.dao.UserMapperPlus;
import cn.gsdx.day01.entity.Department;
import cn.gsdx.day01.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author JackWen
 */
public class UserTest {

    public SqlSessionFactory getSqlSessionFactory(String resource) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        Configuration config;
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = mapper.queryUser(3);
        System.out.println(user);
        openSession.close();
    }
    @Test
    public void test02() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（）设为true时自动提交修改，为 false 时需要手动修改
         */
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = new User(null,"李贵","1234",null,null);

        /**
         * Mybatis自动将返回的影响行数封装为 boolean long Integer
         */
        boolean b = mapper.addUser(user);
        openSession.commit();
        System.out.println(b);
    }

    @Test
    public void test03() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（true）时自动提交修改，
         * 当openSession（）时需要手动提交修改，
         */
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        boolean b = mapper.deleteUser(2);
        System.out.println(b);
    }

    @Test
    public void test04() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（true）时自动提交修改，
         * 当openSession（）时需要手动提交修改，
         */
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUserByNameLike("%李%");
        System.out.println(users);
    }

    @Test
    public void test05() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（true）时自动提交修改，
         * 当openSession（）时需要手动提交修改，
         */
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        Map<String, Object> map = mapper.queryUserReturnMap("李四");
        System.out.println(map);
    }

    @Test
    public void test06() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（true）时自动提交修改，
         * 当openSession（）时需要手动提交修改，
         */
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        Map<String, User> map = mapper.queryUserByNameReturnMap("%李%");
        System.out.println(map);
    }

    @Test
    public void test07() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        /**
         * 当openSession（true）时自动提交修改，
         * 当openSession（）时需要手动提交修改，
         */
        SqlSession openSession = sqlSessionFactory.openSession(true);
        UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);
        User user = mapper.queryUser(1);
        System.out.println(user);
    }

    @Test
    public void test08() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);
        User user = mapper.queryUserPlus(3);
        System.out.println(user.getDepartment());
        System.out.println(user);
    }
    @Test
    public void test09 () throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);
        try {
            Department department = mapper.queryDepartmentByName("销售部");
            System.out.println(department.getDepartmentName());
            System.out.println(department.getUsers());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test10 () throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);
        try {
            List<Department> department = mapper.queryDepartmentByNameStep("销售部");
            System.out.println(department);
            System.out.println();
        }finally {
            openSession.close();
        }
    }

    /**
     * 测试二级缓存
     * @throws IOException
     */
    @Test
    public void test11() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("Mybatis.config.xml");
        SqlSession openSession = sqlSessionFactory.openSession();
        UserMapperPlus mapper1 = openSession.getMapper(UserMapperPlus.class);
        try {
            User user = mapper1.queryUser(1);
            System.out.println(user);
            System.out.println("会话1");
            openSession.close();

            SqlSession openSession1 = sqlSessionFactory.openSession();
            UserMapperPlus mapper2 = openSession1.getMapper(UserMapperPlus.class);
            User user2 = mapper2.queryUser(1);
            System.out.println(user2);
            System.out.println("会话2");
            openSession.close();

            System.out.println(user2==user);

        }finally {
            openSession.close();
        }

    }
}
