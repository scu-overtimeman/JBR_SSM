package com.arch.security.Controller;

import com.arch.security.dto.RespBean;
import com.arch.security.dto.SignUpRequest;
import com.arch.security.entity.User;
import com.arch.security.exception.UserHasBeenRegistedException;
import com.arch.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

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
