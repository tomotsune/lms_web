package io.tomo.lms.dao;


import io.tomo.lms.entity.User;

import java.util.List;

public interface UserDao {

    //1.查询所有学生
    List<User> selectAll();

    //2.按学号查询学生

    //3.2.按姓名查询
    List<User> selectByName(String name);

    //4.添加用户
    void insert(User p);

    //5.更改用户
    void update(User p);

    //6.根据code删除用户
    void  delete(String code);

    User selectById(String id);

    User selectByIdAndPwd(String id,String pwd);
}
