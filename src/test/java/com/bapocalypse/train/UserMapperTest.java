package com.bapocalypse.train;

import com.bapocalypse.train.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: 测试mybatis配置环境是否运行成功
 */
public class UserMapperTest {

    @Before
    public void before() throws Exception {
    }

    @Test
    public void findUserByUId()  {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("user.findUserByUId", 1);
            Assert.assertEquals("张三", user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }

    @After
    public void after() throws Exception {
    }
}
