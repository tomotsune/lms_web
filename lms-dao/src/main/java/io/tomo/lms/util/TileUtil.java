package io.tomo.lms.util;


import io.tomo.lms.exception.DataAccessException;

import java.io.*;
import java.util.Properties;

public class TileUtil{
    private static Properties dataSource;
    static{
            dataSource=new Properties();
        try{

            dataSource.load(TileUtil.class.getClassLoader().getResourceAsStream("datasource.properties"));
        }catch(Exception e){
            throw new ExceptionInInitializerError("FileUtil初始化失败,"+e);
        }
    }

    public static ObjectInputStream getObjectInputStream(String key)throws EOFException{
        try {
            return new ObjectInputStream(new FileInputStream(dataSource.getProperty(key)));

        } catch (EOFException e){
            System.out.println("这是合法的，客户端已经关闭");
            return null;
        }catch(IOException e) {
            throw new DataAccessException("获取输入对象流失败",e);
        }
    }

    public static ObjectOutputStream getObjectOutStream(String key){
        try {
            return new ObjectOutputStream(new FileOutputStream(dataSource.getProperty(key)));
        }catch(IOException e) {
            throw new DataAccessException("获取输出对象流失败 ",e);
        }
    }
    public static void close(OutputStream o){
        if(o!=null){
            try {
                o.close();
            } catch (IOException e) {
                throw new DataAccessException("close OutputStream fail ",e);
            }
        }
    }
    public static void close(InputStream i){
        if(i!=null){
            try {
                i.close();
            } catch (IOException e) {
                throw new DataAccessException("close InputStream fail ",e);
            }
        }
    }
}
