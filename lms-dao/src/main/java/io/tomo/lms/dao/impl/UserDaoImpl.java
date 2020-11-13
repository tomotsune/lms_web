package io.tomo.lms.dao.impl;


import io.tomo.lms.dao.UserDao;
import io.tomo.lms.entity.User;
import io.tomo.lms.util.FileTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User selectById(String id) {
        var map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("type", "User");
        String exp = "Object.getId().equals(id)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public User selectByIdAndPwd(String id, String pwd) {
        var map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("pwd", pwd);
        map.put("type", "User");
        String exp = new StringBuffer()
                .append("Object.getId().equals(id)")
                .append("&&")
                .append("Object.getPwd().equals(pwd)")
                .toString();
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public void update(User p) {
        var map = new HashMap<String, Object>();
        map.put("type", "User");
        List<User> oldList = FileTemplate.query(null, map);
        oldList.remove(selectById(p.getId()));
        oldList.add(p);
        FileTemplate.update("User",oldList);
    }


    @Override
    public List<User> selectAll() {
        var map = new HashMap<String, Object>();
        map.put("type", "User");
        return FileTemplate.query(null, map);
    }


    @Override
    public List<User> selectByName(String name) {
        var map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("type", "User");
        String exp = "Object.getName().equals(name)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public void insert(User p) {
        var map = new HashMap<String, Object>();
        map.put("type", "User");
        List<User> oldList = FileTemplate.query(null, map);
        oldList.add(p);
        FileTemplate.update("User",oldList);
    }

    @Override
    public void delete(String id) {
        var map = new HashMap<String, Object>();
        map.put("type", "User");
        List<User> oldList = FileTemplate.query(null, map);
        oldList.remove(selectById(id));
        FileTemplate.update("User", oldList);
    }

}
