package io.tomo.lms.service.impl;


import io.tomo.lms.dao.BookDao;
import io.tomo.lms.dao.ListDao;
import io.tomo.lms.dao.UserDao;
import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UserNotFoundException;
import io.tomo.lms.exception.UsernameExistException;
import io.tomo.lms.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User login(String id, String pwd) throws UserNotFoundException {
        User u = userDao.selectByIdAndPwd(id, pwd);
        if (u == null) throw new UserNotFoundException("用户名或密码错误");
        return u;
    }

    @Override
    public void register(User user) throws UsernameExistException {
        User p = userDao.selectById(user.getId());
        if (p != null) throw new UsernameExistException("用户已存在");
        userDao.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }


    @Override
    public User findById(String id) throws UserNotFoundException {
        User user = userDao.selectById(id);
        if (user == null) throw new UserNotFoundException("没有该用户");
        return user;
    }


    @Override
    public List<User> findByName(String name) throws UserNotFoundException {
        List<User> list = userDao.selectByName(name);
        if (list.isEmpty()) throw new UserNotFoundException("没有该用户");
        return list;
    }

    @Override
    public void add(User p) throws UsernameExistException {
        User user = userDao.selectById(p.getId());
        if (user != null) throw new UsernameExistException("用户名已存在");
        userDao.insert(p);
    }

    @Override
    public void modify(User p) throws UserNotFoundException {
        User user = userDao.selectById(p.getId());
        if (user == null) throw new UserNotFoundException("没有该用户");
        userDao.update(p);
    }

    @Override
    public void removeById(String id) throws UserNotFoundException {
        User user = userDao.selectById(id);
        if (user == null) throw new UserNotFoundException("用户不存在");
        userDao.delete(id);
    }
}
