package com.bapocalypse.train;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description: springMVC的测试基础类
 */
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration("classpath:spring/springmvc.xml")
public abstract class BaseControllerTest extends BaseJunit4Test{
}
