package com.slj.jinjihu.backend.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * SessionInterceptor 处理登录逻辑判断
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeUrl = Arrays.asList("/user/login");
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludeUrl);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer2() {
        return new WebMvcConfigurer() {
            /**
             * 设置头 使可以跨域访问
             * @param registry
             * @since 4.2
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //是否发送Cookie
                        .allowCredentials(true)
                        //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                        .allowedOriginPatterns("*")
                        //放行哪些请求方式
                        .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                        //.allowedMethods("*") //或者放行全部
                        //放行哪些原始请求头部信息
                        .allowedHeaders("*","Authorization")
                        //暴露哪些原始请求头部信息
                        .exposedHeaders("*");
            }
        };
    }
}