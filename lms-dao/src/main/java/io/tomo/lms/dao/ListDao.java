package io.tomo.lms.dao;

import java.util.List;

public interface ListDao {
    //1.查询所有图书
    public List<io.tomo.lms.entity.List> selectAll();

    //2.按id查询图书
    io.tomo.lms.entity.List selectBySerialNo(int no);

    //3.2.按姓名查询
    List<io.tomo.lms.entity.List> selectById(String id);

    List<io.tomo.lms.entity.List> selectByNo(int no);


    //4.更改用户
    void update(io.tomo.lms.entity.List p);

    //5.根据ID删除用户
    void delete(int serialNo);

    //4.添加用户
    void insert(io.tomo.lms.entity.List p);

    int getCount();
}
