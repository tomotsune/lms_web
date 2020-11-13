package io.tomo.lms.dao;



import io.tomo.lms.entity.Book;

import java.util.List;

public interface BookDao {

    //1.查询所有图书
    public List<Book> selectAll();

    //2.按id查询图书
    Book selectByNo(int no);


    //3.2.按姓名查询
    List<Book> selectByName(String name);

    List<Book> selectByAuthor(String author);

    //4.更改用户
    void update(Book p);

    //5.根据ID删除用户
    void delete(int id);

    //4.添加用户
    void insert(Book p);
}
