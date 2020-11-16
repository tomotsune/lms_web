package io.tomo.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:使用@SpringBootApplication标注主程序类, 表示这是一个SpringBoot应用.
 */
//加载外部的Spring配置文件
/*@ImportResource({"classpath:applicationContext.xml"})*/
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //启动SpringBoot应用.

        SpringApplication.run(MainApplication.class,args);//传入主程序类的Class对象
    }
}
