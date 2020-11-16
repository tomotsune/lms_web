package io.tomo.lms.config;

import io.tomo.lms.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:扩展默认的SpringMVC功能
 * 要求:
 * 1. 使用@Configuration标注为配置类
 * 2. 实现WebMvcConfigurer.
 * 3. 根据需要实现相应的方法
 * 注: 这个接口中的方法都添加了jdk1.8中的default方法修饰, 不强制实现所有的方法(jdk1.8).
 */
@Configuration
public class CustomConfig implements WebMvcConfigurer {
    //添加ViewController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问shoLogin时跳转到login试图
        registry.addViewController("/showLogin").setViewName("login");
    }
    //添加interceptor.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/showLogin");
    }
}
