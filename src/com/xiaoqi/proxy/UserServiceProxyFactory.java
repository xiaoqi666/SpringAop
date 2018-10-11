package com.xiaoqi.proxy;

import com.xiaoqi.service.UserService;
import com.xiaoqi.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxyFactory implements InvocationHandler {

    private UserService us;

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    public UserService getUserServiceProxy() {
        //生成动态代理
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader()
                , UserServiceImpl.class.getInterfaces(), this/*实现InvocationHandler的类,本类*/);
        return usProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务");
        Object invoke = method.invoke(us, args);//业务方法的执行
        System.out.println("关闭事务");
        return invoke;
    }
}
