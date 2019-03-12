package com.jbr.backend.Controller;

import com.jbr.backend.dto.request.ModifyUserRolesRequest;
import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.request.SignUpRequest;
import com.jbr.backend.entity.Role;
import com.jbr.backend.entity.User;
import com.jbr.backend.exception.UserHasBeenRegistedException;
import com.jbr.backend.service.RoleService;
import com.jbr.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/registry")
    public @ResponseBody
    RespBean UserRegistry(@RequestBody SignUpRequest request, HttpSession session) {
        User user = new User();
        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());
        try {
            userService.register(user);
            return RespBean.ok("注册成功");
        } catch (UserHasBeenRegistedException e) {
            RespBean respBean = RespBean.error("用户名已存在");
            respBean.setStatus(250);
            return respBean;
        } catch (Exception e) {
            return RespBean.error("注册失败");
        }
    }
    @PostMapping("/modifyRoles")
    @Secured("ROLE_ADMIN")
    public @ResponseBody RespBean modifyUserRoles(@RequestBody ModifyUserRolesRequest request){
        try{
            roleService.setUserRoles(request.getUserId(),request.getRoleIds());
            return RespBean.ok("修改用户权限成功");
        }catch (Exception e){
            return RespBean.error("修改用户权限失败");
        }
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/allUsers")
    public @ResponseBody RespBean getAllUsers(){
        try{
            return RespBean.ok("获取所有用户信息成功",userService.getAllUsers());
        }catch (Exception e){
            return RespBean.error("获取用户信息失败");
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/allRoles")
    public @ResponseBody RespBean getAllRoles(){
        try{
            return RespBean.ok("获取所有角色信息成功",roleService.getAllRoles());
        }catch (Exception e){
            return RespBean.error("获取角色信息失败");
        }
    }
    @GetMapping("/test")
    public @ResponseBody RespBean test(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        List<Role> roles= new ArrayList<Role>();
        Role role1 = new Role();
        role1.setName("ROLE_ADMIN");
        Role role2 = new Role();
        role2.setName("ROLE_VIP");
        roles.add(role1);
        roles.add(role2);
        user.setRoles(roles);
        return RespBean.ok("成功",user);
    }
}
