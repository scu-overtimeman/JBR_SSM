package com.jbr.backend;

import com.jbr.backend.dao.UserDao;
import com.jbr.backend.entity.Position;
import com.jbr.backend.service.HadoopService;
import com.jbr.backend.service.SearchService;
import com.jbr.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05SecurityApplicationTests {

    @Autowired
    HadoopService hadoopService;
    @Test
    public void contextLoads() throws Exception {
        hadoopService.areaSearch("四川省-成都市");
    }
}
