package com.jbr.backend;

import com.jbr.backend.dao.UserDao;
import com.jbr.backend.entity.Position;
import com.jbr.backend.entity.User;
import com.jbr.backend.service.HadoopService;
import com.jbr.backend.service.SearchService;
import com.jbr.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05SecurityApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    SearchService searchService;
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() throws Exception {
        List<Position> positions = searchService.salarySearch("5000", "20000");
        System.out.println(positions);

    }
}
