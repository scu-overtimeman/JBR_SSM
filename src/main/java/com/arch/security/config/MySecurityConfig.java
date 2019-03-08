package com.arch.security.config;

import com.arch.security.dto.RespBean;
import com.arch.security.service.CustomUserService;
import com.arch.security.utils.UserUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;

import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;


    @Autowired
    CustomUserService customUserService;
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(auth);
        //定制请求的授权规则
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能 如果没有权限 就重定向到登录页面
        //1. /login请求来到登录页
        //2. 重定向到/login?error表示登录失败
        //3.更多详细规则
        http.csrf().disable().exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                RespBean error = RespBean.error("权限不足，请联系管理员!");
                returnJson(httpServletResponse, error);
            }
        });
        //暂时关闭csrf
        http.formLogin().loginProcessingUrl("/login").failureForwardUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("登录成功", UserUtils.getCurrentUser());
                        returnJson(httpServletResponse, respBean);
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req,
                                                HttpServletResponse httpServletResponse,
                                                AuthenticationException e) throws IOException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                RespBean respBean = null;
                if (e instanceof BadCredentialsException ||
                        e instanceof UsernameNotFoundException) {
                    respBean = RespBean.error("账户名或者密码输入错误!");
                } else if (e instanceof LockedException) {
                    respBean = RespBean.error("账户被锁定，请联系管理员!");
                } else if (e instanceof CredentialsExpiredException) {
                    respBean = RespBean.error("密码过期，请联系管理员!");
                } else if (e instanceof AccountExpiredException) {
                    respBean = RespBean.error("账户过期，请联系管理员!");
                } else if (e instanceof DisabledException) {
                    respBean = RespBean.error("账户被禁用，请联系管理员!");
                } else {
                    respBean = RespBean.error("登录失败!");
                }
                httpServletResponse.setStatus(401);
                returnJson(httpServletResponse, respBean);
            }
        });
        http.logout().logoutSuccessUrl("/");
        //1.访问/logout 表示用户注销，清空session
        //2.注销成功会返回 /login?logout页面
        //3..logoutSuccessUrl("/") 设定注销成功以后的地址
        //4.默认post形式的/login 代表处理登录
        //5.一旦定制loginpage 那么post请求就是登录
        //也可以设置loginProcessingUrl
        //开启记住我
        http.rememberMe().rememberMeParameter("remember");
        //登录成功以后，将cookie发给浏览器保存，以后登录带上cookie 通过检查就免登录 如果点击注销 会删除cookie
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    private void returnJson(HttpServletResponse httpServletResponse, RespBean respBean) throws IOException {
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}