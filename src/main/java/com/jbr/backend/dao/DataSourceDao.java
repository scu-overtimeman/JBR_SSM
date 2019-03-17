package com.jbr.backend.dao;

import com.jbr.backend.entity.DataSource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface DataSourceDao extends tk.mybatis.mapper.common.Mapper<DataSource> {

    @Delete("DELETE FROM data_source")
    boolean deleteAllDataSourece();

}




