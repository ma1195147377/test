package com.zheng;

import com.zheng.dao.UserDao;
import com.zheng.entity.User;

import com.zheng.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    @Test
    public void selectTest() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.zheng.dao.UserDao.selectUsers";
        List<User> userList = sqlSession.selectList(sqlId);
        for(User user: userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void insertTest() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        String sqlId = "com.zheng.dao.UserDao.insertUser";
        User user = new User("苏沐白","pojiangling","练剑");
        int i = sqlSession.insert(sqlId,user);
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void utilTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.zheng.dao.UserDao.selectUsers";
        List<User> userList = sqlSession.selectList(sqlId);
        for(User user: userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void newTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> userList = dao.selectUsers();
        for(User user: userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void updateTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User(10,"万千雪","snow","吹雪");
        int i = dao.updateUser(user);
        System.out.println("sql语句执行成功的次数："+i);
        sqlSession.close();
    }
    @Test
    public void newseTest() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        //user.setName("王五");
        user.setHobby("看动漫");
        List<User> userList = dao.newSelect(user);
        for(User users: userList){
            System.out.println(users);
        }
        sqlSession.close();
    }
}
