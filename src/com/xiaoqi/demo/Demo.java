package com.xiaoqi.demo;

import com.xiaoqi.domain.User;
import com.xiaoqi.proxy.UserServiceProxyFactory;
import com.xiaoqi.proxy.UserServiceProxyFactory2;
import com.xiaoqi.service.UserService;
import com.xiaoqi.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
@ContextConfiguration("classpath:spring-config.xml")//指定创建容器时使用哪个配置文件
public class Demo {

    @Resource(name = "user")//将名为user的对象注入到user变量中
    private User user;


    @Resource(name = "userServiceTarget")
    private UserService us;


    @Test
    public void fun() {
        us.save();
    }

    @Test
    //使用动态代理,手动代理
    public void test() {
        UserService us = new UserServiceImpl();
        UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
        UserService usProxy = factory.getUserServiceProxy();
        usProxy.save();
    }

    @Test
    //cglib代理
    public void test2() {
        UserServiceProxyFactory2 factory2 = new UserServiceProxyFactory2();
        UserService usProxy = factory2.getUserServiceProxy();
        usProxy.save();
    }


}
