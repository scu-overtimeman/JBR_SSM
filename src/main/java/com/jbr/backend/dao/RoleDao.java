package com.jbr.backend.dao;

import com.jbr.backend.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Component
@Mapper
public interface RoleDao extends tk.mybatis.mapper.common.Mapper<Role> {
    @Select("select * from role where id in (select role_id as id from user_role where user_id = #{id})")
    List<Role> selectAllRolesByUserId(int id);
}




