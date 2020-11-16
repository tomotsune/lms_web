package io.tomo.lms.config;

import io.tomo.lms.dao.UserDao;
import io.tomo.lms.dao.impl.UserDaoImpl;
import io.tomo.lms.service.UserService;
import io.tomo.lms.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//标注在类上, 表示这是一个配置类, 相当于以前写的Spring配置文件
@Configuration
public class SpringConfig {
    //标注在方法上, 向容器中添加一个组件, 将方法的返回值添加到容器中.
    //方法名作为组件id.
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userDao());
    }
}
