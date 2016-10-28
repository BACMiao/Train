package com.bapocalypse.train;

import com.bapocalypse.train.dao.UserDao;
import com.bapocalypse.train.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: 测试mybatis配置环境是否运行成功
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        String resource = "mybatis/sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
    * @Description:由于使用mapper开发代理方法，此测试用例失效
    * */
    @Test
    public void findUserByUId1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserByUId", 1);
        Assert.assertEquals("张三", user.getName());
        sqlSession.close();
    }

    @Test
    public void findUserByUId2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserDao对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            User user = userDao.findUserByUid(1);
            Assert.assertEquals("张三", user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }



    @After
    public void after() throws Exception {
    }
}
