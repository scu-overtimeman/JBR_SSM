package com.arch.security.config;

import com.arch.security.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(auth);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能 如果没有权限 就重定向到登录页面
        //1. /login请求来到登录页
        //2. 重定向到/login?error表示登录失败
        //3.更多详细规则

        http.formLogin().loginPage("/userlogin").failureForwardUrl("/login?error");
        http.logout().logoutSuccessUrl("/");
        //1.访问/logout 表示用户注销，清空session
        //2.注销成功会返回 /login?logout页面
        //3..logoutSuccessUrl("/") 设定注销成功以后的地址



        //开启记住我
        http.rememberMe();
        //登录成功以后，将cookie发给浏览器保存，以后登录带上cookie 通过检查就免登录 如果点击注销 会删除cookie


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
    }
}
