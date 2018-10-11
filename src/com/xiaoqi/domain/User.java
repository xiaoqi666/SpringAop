package com.xiaoqi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Component("user")   //  相当于 <bean name="user" class="com.xiaoqi.domain.User"/>
//同上没区别
//@Service("user")  service层
//@Controller("user")  web层
//@Repository("user")  dao层
@Scope(scopeName = "prototype")
public class User {
    @Value("tom")//给属性赋值或者放在set方法上一行也可以(建议放在set上,实际都是放在属性上)
    private String name;
    @Value(value = "18")
    private int age;
    //    @Autowired//自动装配,如果匹配到多个类型一致的对象,无法选择
//    @Qualifier("car2")//告诉spring容器自动装配哪个名称的对象
    @Resource(name = "car")//手动注入,指定注入哪个名称的对象(推荐)
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
