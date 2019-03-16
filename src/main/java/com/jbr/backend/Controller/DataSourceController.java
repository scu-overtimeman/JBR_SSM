package com.jbr.backend.Controller;

import com.jbr.backend.dao.DataSourceDao;
import com.jbr.backend.dto.RespBean;
import com.jbr.backend.entity.DataSource;
import com.jbr.backend.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;


    @GetMapping("/getAllDataSource")
    public RespBean getAllDataSource(){
        List<DataSource> dataSource = dataSourceService.getAllDataSource();
        return RespBean.ok("所有数据源",dataSource);
    }
//    @PostMapping("/updateDataSource")
//    public RespBean updateDataSource(@RequestBody List<DataSource> dataSources){
//
//    }
}
