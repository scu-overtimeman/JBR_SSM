package com.jbr.backend.service;

import com.jbr.backend.dao.RoleDao;
import com.jbr.backend.dao.UserDao;
import com.jbr.backend.dao.UserRoleDao;
import com.jbr.backend.entity.Role;
import com.jbr.backend.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
@Transactional
public class RoleService {
    final RoleDao roleDao;
    final UserRoleDao userRoleDao;
    @Autowired
    RoleService(RoleDao roleDao, UserRoleDao userRoleDao){
        this.userRoleDao = userRoleDao;
        this.roleDao = roleDao;
    }
    @Secured("ROLE_ADMIN")
    public List<Role> getAllRoles(){
        return roleDao.selectAll();
    }


    @Secured("ROLE_ADMIN")
    public void setUserRoles(Integer userId,List<Integer> roleIds){

            deleteUserAllRoles(userId);
            for (Integer roleId : roleIds) {
                userRoleDao.insert(new UserRole(userId, roleId));
            }
    }
    @Secured("ROLE_ADMIN")
    private void deleteUserAllRoles(int userId){
        try {
            Example example = new Example(UserRole.class);
            example.createCriteria().andEqualTo("userId", userId);
            userRoleDao.deleteByExample(example);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
