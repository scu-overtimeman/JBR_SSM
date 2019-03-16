package com.jbr.backend.service;

import com.jbr.backend.dao.DataSourceDao;
import com.jbr.backend.entity.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceService {

    @Autowired
    DataSourceDao dataSourceDao;

    public List<DataSource> getAllDataSource(){
        List<DataSource> dataSources = dataSourceDao.selectAll();
        return dataSources;
    }
    public void deleteAllDataSource(){


    }
}
