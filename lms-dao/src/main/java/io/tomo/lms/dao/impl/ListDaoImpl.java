package io.tomo.lms.dao.impl;


import io.tomo.lms.dao.ListDao;
import io.tomo.lms.entity.User;
import io.tomo.lms.util.FileTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.List;
public class ListDaoImpl implements ListDao {

    @Override
    public java.util.List<io.tomo.lms.entity.List> selectAll() {
        var map = new HashMap<String, Object>();
        map.put("type", "List");
        return FileTemplate.query(null, map);
    }

    @Override
    public io.tomo.lms.entity.List selectBySerialNo(int serialNo) {
        var map = new HashMap<String, Object>();
        map.put("serialNo", serialNo);
        map.put("type", "List");
        String exp = "Object.getSerialNo().equals(serialNo)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public java.util.List<io.tomo.lms.entity.List> selectById(String id) {
        var map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("type", "List");
        String exp = "Object.getId().equals(id)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public List<io.tomo.lms.entity.List> selectByNo(int no) {
        var map = new HashMap<String, Object>();
        map.put("no", no);
        map.put("type", "List");
        String exp = "Object.getNo().equals(no)";
        return FileTemplate.queryForObject(exp, map);
    }

    @Override
    public void update(io.tomo.lms.entity.List p) {
        var map = new HashMap<String, Object>();
        map.put("type", "List");
        java.util.List<io.tomo.lms.entity.List> oldList = FileTemplate.query(null, map);
        oldList.remove(selectBySerialNo(p.getSerialNo()));
        oldList.add(p);
        FileTemplate.update("List",oldList);
    }

    @Override
    public void delete(int serialNo) {
        var map = new HashMap<String, Object>();
        map.put("type", "List");
        java.util.List<io.tomo.lms.entity.List> oldList = FileTemplate.query(null, map);
        oldList.remove(selectBySerialNo(serialNo));
        FileTemplate.update("List",oldList);
    }

    @Override
    public void insert(io.tomo.lms.entity.List p) {
        var map = new HashMap<String, Object>();
        map.put("type", "List");
        List<io.tomo.lms.entity.List> oldList = FileTemplate.query(null, map);
        oldList.add(p);
        FileTemplate.update("List",oldList);
    }

    @Override
    public int getCount() {
        var map = new HashMap<String, Object>();
        map.put("type", "List");
        return FileTemplate.getCount(null, map);
    }
}
