package io.tomo.lms.util;

import io.tomo.lms.exception.DataAccessException;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileTemplate {
    /**
     * 查询操作
     */

    public static <T> ArrayList<T> query(String exp, HashMap<String, Object> map) {
        List<T> list = new ArrayList<>();
        ObjectInputStream fin = null;
        try {
            fin = TileUtil.getObjectInputStream((String) map.get("type"));
            if (fin == null) return new ArrayList<T>();
            List<T> in = (List<T>) fin.readObject();
            /* System.out.println(in);*/
            if (exp == null) return new ArrayList<T>(in);
            for (T item : in) {
                map.put("Object", item);
                if ((Boolean) CodeConverter.convertToCode(exp, map)) {
                    list.add((T) item);
                }
            }
           /* in.forEach((item) -> {

                map.put("Object", item);
                if ((Boolean) CodeConverter.convertToCode(exp, map)) {
                    list.add((T) item);
                }
            });*/

        } catch (IOException | ClassNotFoundException e) {
            throw new DataAccessException("query fail", e);
        } finally {
            TileUtil.close(fin);
        }
        return new ArrayList<T>(list);
    }

    /**
     * 查询单个
     */
    public static <T> T queryForObject(String exp, HashMap<String, Object> map) {
        List<T> list = query(exp, map);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 更新操作
     */
    public static <T> void update(String typeName, List<T> list) {
        ObjectOutputStream fou = null;
        try {
            fou = TileUtil.getObjectOutStream(typeName);
            fou.writeObject(list);

        } catch (IOException e) {
            throw new DataAccessException("update fail", e);
        } finally {
            TileUtil.close(fou);
        }
    }

    @SafeVarargs
    public static <T> void update(String typeName, T... params) {
        update(typeName, params);
    }


    public static <T> int getCount(String exp, HashMap<String, Object> map) {
        return query(exp, map).size();
    }
}