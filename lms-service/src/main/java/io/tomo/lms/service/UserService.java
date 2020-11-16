package io.tomo.lms.service;


import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UserNotFoundException;
import io.tomo.lms.exception.UsernameExistException;

import java.util.List;

public interface UserService {

    // 0.1登录
    User login(String id, String pwd) throws UserNotFoundException;

    // 0.2注册
    void register(User user) throws UsernameExistException;

    //1.查询所有学生
    List<User> findAll();

    //2.按学号查询学生
    User findById(String id) throws UserNotFoundException;


    //3.2.按姓名查询
    List<User> findByName(String name) throws UserNotFoundException;


    //4.添加用户
    void add(User p) throws UsernameExistException;

    //5.更改用户
    void modify(User p) throws UserNotFoundException;

    void removeById(String id) throws UserNotFoundException;

}
