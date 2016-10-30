package com.bapocalypse.train;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description: 一般测试的基础类
 */
//注解让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-transaction.xml",
        "classpath:spring/spring-service.xml"})
@Transactional
@Rollback(value = true)
public abstract class BaseJunit4Test {
}