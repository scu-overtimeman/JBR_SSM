package com.jbr.backend.Controller;

import com.jbr.backend.dto.ModifyUserRolesRequest;
import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.SignUpRequest;
import com.jbr.backend.entity.User;
import com.jbr.backend.exception.UserHasBeenRegistedException;
import com.jbr.backend.service.RoleService;
import com.jbr.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
            return RespBean.error("用户名重复");
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
}
