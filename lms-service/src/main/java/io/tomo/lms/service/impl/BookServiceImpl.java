package io.tomo.lms.service.impl;

import io.tomo.lms.dao.BookDao;
import io.tomo.lms.entity.Book;
import io.tomo.lms.exception.BookNotFoundException;
import io.tomo.lms.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book findById(int no) throws BookNotFoundException {
        Book book = bookDao.selectByNo(no);
        if (book == null) throw new BookNotFoundException("没有找到该书" + no);
        return book;
    }


    @Override
    public List<Book> findByName(String name) throws BookNotFoundException {

        List<Book> books = bookDao.selectByName(name);
        if (books.isEmpty()) throw new BookNotFoundException("没有找到该书" + name);
        return books;
    }

    @Override
    public void add(Book p) {
        Book book = bookDao.selectByNo(p.getNo());
        if (book != null) {
            book.setCount(book.getCount() + p.getCount());
        } else {
            bookDao.insert(p);
        }
    }

    @Override
    public void modify(Book p) throws BookNotFoundException {
        Book book = bookDao.selectByNo(p.getNo());
        if (book == null) {
            throw new BookNotFoundException("没有找到该书" + p.getNo());
        }
        bookDao.update(p);
    }

    @Override
    public void removeByNo(int no) throws BookNotFoundException {
        Book book = bookDao.selectByNo(no);
        if (book == null) {
            throw new BookNotFoundException("没有找到该书" + no);
        }
        bookDao.delete(no);
    }

}

