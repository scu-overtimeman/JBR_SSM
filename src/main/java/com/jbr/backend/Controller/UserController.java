package com.jbr.backend.Controller;

import com.jbr.backend.dto.RespBean;
import com.jbr.backend.dto.SignUpRequest;
import com.jbr.backend.entity.User;
import com.jbr.backend.exception.UserHasBeenRegistedException;
import com.jbr.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
}
