package io.tomo.lms.service;



import io.tomo.lms.entity.Book;
import io.tomo.lms.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

    //1.查询所有
    List<Book> findAll();

    //2.按学号查询
    Book findById(int id) throws BookNotFoundException;

    //3.2.按姓名查询
    List<Book> findByName(String name) throws BookNotFoundException;
    

    //4.添加
    void add(Book p);

    //5.更改
    void modify(Book p) throws BookNotFoundException;

    //6.根据ID删除
    void removeByNo(int no) throws BookNotFoundException;


}
