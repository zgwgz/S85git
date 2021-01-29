package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * 搞一个配置类，用于springmvc的拓展
 * 大多数的配置已经由springboot完成，但是我们在实际开发中还需要定制我们自己的需求的springmvc配置，因此
 * 我们可以使用配置类的方式来警醒拓展
 * 该类要实现   WebMvcConfigurer,然后就可以重写相关的方法
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 该方法可添加自己的视图解析映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //当我们访问
        // http://localhost:8080/
        // 的时候，会自动跳转到login页面
        registry.addViewController("/index.html").setViewName("login");
        //
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     /*   registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/*")
                .excludePathPatterns("/index.html","/user/login","/asserts/**");*/
    }

    @Bean
    public LoginHandlerInterceptor getLoginHandlerIntercepter(){
        return new LoginHandlerInterceptor();
    }



    /**
     * 将自定义的组件添加进入SpringMVC
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
