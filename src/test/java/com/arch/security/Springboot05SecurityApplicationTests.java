package com.arch.security;

import com.arch.security.dao.RoleDao;
import com.arch.security.dao.UserDao;
import com.arch.security.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05SecurityApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    public void contextLoads() {
        for(int i = 0;i<10;i++){

        }
    }
}
