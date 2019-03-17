package com.jbr.backend;

import com.jbr.backend.dao.DataSourceDao;
import com.jbr.backend.dao.UserDao;

import com.jbr.backend.entity.DataSource;
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
    DataSourceDao dataSourceDao;
    @Test
    public void contextLoads() throws Exception {

//        hadoopService.educationStatistics("教师");
//        hadoopService.salaryStatistics();
        List<DataSource> dataSources = dataSourceDao.selectAll();
        for (DataSource e :
                dataSources) {
            System.out.println(e);
        }
    }
}
