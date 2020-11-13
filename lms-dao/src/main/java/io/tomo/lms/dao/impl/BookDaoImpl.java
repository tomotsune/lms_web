package io.tomo.lms.dao.impl;


import io.tomo.lms.dao.BookDao;
import io.tomo.lms.entity.Book;
import io.tomo.lms.util.FileTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.List;


public class BookDaoImpl implements BookDao {


    @Override
    public void insert(Book p) {
        var map = new HashMap<String, Object>();
        map.put("type", "Book");
        List<Book> oldList = FileTemplate.query(null, map);
        oldList.add(p);
        FileTemplate.update("Book", oldList);
    }

    @Override
    public Book selectByNo(int no) {
        var map = new HashMap<String, Object>();
        map.put("id", no);
        map.put("type", "Book");
        String exp = "Book.getNo.equals(no)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public List<Book> selectByName(String name) {
        var map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("type", "Book");
        String exp = "Book.getName.equals(name)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public List<Book> selectByAuthor(String author) {
        var map = new HashMap<String, Object>();
        map.put("author", author);
        map.put("type", "Book");
        String exp = "Book.getAuthor.equals(author)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public List<Book> selectAll() {
        var map = new HashMap<String, Object>();
        map.put("type", "Book");
        return FileTemplate.query(null, map);
    }


    @Override
    public void update(Book p) {
        var map = new HashMap<String, Object>();
        map.put("type", "Book");
        List<Book> oldList = FileTemplate.query(null, map);
        oldList.remove(selectByNo(p.getNo()));
        oldList.add(p);
        FileTemplate.update("Book", oldList);
    }

    @Override
    public void delete(int no) {
        var map = new HashMap<String, Object>();
        map.put("type", "Book");
        List<Book> oldList = FileTemplate.query(null, map);
        oldList.remove(selectByNo(no));
        FileTemplate.update("Book", oldList);
    }


}
