package io.tomo.lms.service.impl;



import io.tomo.lms.dao.BookDao;
import io.tomo.lms.dao.ListDao;
import io.tomo.lms.dao.UserDao;
import io.tomo.lms.entity.Book;
import java.util.List;
import io.tomo.lms.entity.User;
import io.tomo.lms.exception.BookNotFoundException;
import io.tomo.lms.exception.TableNotFoundException;
import io.tomo.lms.exception.UserNotFoundException;
import io.tomo.lms.factory.ObjectFactory;
import io.tomo.lms.service.ListService;

import java.util.Date;

public class ListServiceImpl implements ListService {
    BookDao bookDao = (BookDao) ObjectFactory.getObject("bookDao");
    UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");
    ListDao listDao = (ListDao) ObjectFactory.getObject("listDao");

    @Override
    public void lendBook(String id, int no, String op) throws BookNotFoundException, UserNotFoundException {
        User user = userDao.selectById(id);
        if (user == null) throw new UserNotFoundException("没有找到该人" + id);
        Book book = bookDao.selectByNo(no);
        if (book == null) throw new BookNotFoundException("没有找到该书" + no);
        if (book.getCount() == 0) throw new BookNotFoundException("没有库存" + no);
        book.setCount(book.getCount() - 1);
        io.tomo.lms.entity.List list = new io.tomo.lms.entity.List(listDao.getCount() + 1, id, no, new Date(), 2, op);
        listDao.insert(list);
    }

    @Override
    public void returnBack(int serialNo) throws TableNotFoundException, BookNotFoundException {
        io.tomo.lms.entity.List list = listDao.selectBySerialNo(serialNo);
        if (list == null) throw new TableNotFoundException("没有找到该条记录" + serialNo);
        int no = listDao.selectBySerialNo(serialNo).getNo();
        Book book = bookDao.selectByNo(no);
        if (book == null) throw new BookNotFoundException("没有找到该书" + no);
        book.setCount(book.getCount() + 1);
        listDao.delete(serialNo);
    }

    @Override
    public List<io.tomo.lms.entity.List> findAll() throws TableNotFoundException {
        return listDao.selectAll();
    }

    @Override
    public List<io.tomo.lms.entity.List> findId(String id) throws TableNotFoundException {
        List<io.tomo.lms.entity.List> lists = listDao.selectById(id);
        if(lists.isEmpty())throw new TableNotFoundException(id+"没有借书记录");
        return lists;
    }

    @Override
    public java.util.List<io.tomo.lms.entity.List> findNo(int no) throws TableNotFoundException {
        List<io.tomo.lms.entity.List> lists = listDao.selectByNo(no);
        if(lists.isEmpty())throw new TableNotFoundException(no+"没有出借记录");
        return lists;
    }

    @Override
    public io.tomo.lms.entity.List findSerialNo(int serialNo) throws TableNotFoundException {
        io.tomo.lms.entity.List list = listDao.selectBySerialNo(serialNo);
        if(list==null)throw new TableNotFoundException(serialNo+"没有记录");
        return list;
    }


}
