package com.xiaoqi.proxy;

import com.xiaoqi.service.UserService;
import com.xiaoqi.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理
 */
public class UserServiceProxyFactory2 implements MethodInterceptor {

    public UserService getUserServiceProxy() {
        Enhancer en = new Enhancer();
        en.setSuperclass(UserServiceImpl.class);//设置对谁进行代理
        en.setCallback(this);//代理要做什么
        UserService us = (UserService) en.create();
        return us;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //打开事务
        System.out.println("打开事务");
        //调用原有方法
        Object o1 = methodProxy.invokeSuper(o, objects);
        //提交事务
        System.out.println("提交事务");
        return o1;
    }
}
