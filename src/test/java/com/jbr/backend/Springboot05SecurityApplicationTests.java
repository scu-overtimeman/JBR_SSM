package com.jbr.backend;

import com.jbr.backend.dao.UserDao;
import com.jbr.backend.entity.User;
import com.jbr.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05SecurityApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        for(int i = 0;i<10;i++){

        }
    }
    @Test
    public void userServiceTest(){
        User user = new User();
        user.setUsername("lisi");
        userDao.insert(user);
    }

}
