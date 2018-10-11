package com.xiaoqi.service;


public class UserServiceImpl implements UserService {


    @Override
    public void save() {
//        System.out.println("打开事务");
//        System.out.println("保存用户!!!");
//        System.out.println("提交事务");


        System.out.println("保存用户!!!");

    }

    @Override
    public void delete() {
        System.out.println("delete");

    }

    @Override
    public void update() {
        System.out.println("update");

    }

    @Override
    public void find() {
        System.out.println("find");

    }
}
