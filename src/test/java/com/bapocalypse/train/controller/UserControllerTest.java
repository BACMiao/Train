package com.bapocalypse.train.controller;

import com.bapocalypse.train.BaseControllerTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description: UserController的测试类
 */
public class UserControllerTest extends BaseControllerTest {
    @Autowired
    private WebApplicationContext wac;  //注入web环境的ApplicationContext容器

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //创建一个MockMvc进行测试
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetUser() throws Exception {
        /*
        * MockMvcRequestBuilders.get("/user/usersView/1"))构造一个请求
        * ResultActions.andExpect添加执行完成后的断言
        * ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
        * ResultActions.andReturn表示执行完成后返回相应的结果
        * */
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testSaveUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                    .param("username", "lisilin")
                    .param("password", "123456")
                    .param("name", "李四")
                    .param("IDType", "1")
                    .param("ID", "345397125864123485")
                    .param("email", "3453971")
                    .param("telephone", "12354621369")
                    .param("passenger","1"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertNotNull(result.getResponse().getHeaderNames());
    }

    @Test
    public void testUpdateUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                    .param("telephone", "12354621369")
                    .param("passenger","2")
                    .param("password", "123123"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDeleteUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testLoginUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                    .param("username", "zhangsan")
                    .param("password", "1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
