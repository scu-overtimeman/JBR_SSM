package com.jbr.backend.service;

import com.jbr.backend.dao.UserDao;
import com.jbr.backend.entity.Role;
import com.jbr.backend.entity.User;
import com.jbr.backend.exception.UserHasBeenRegistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        return user;
    }

    public User SelectUserByName(String userName) {
        return userDao.selectByUsername(userName);
    }

    public Boolean register(User user) {
        if (SelectUserByName(user.getUsername()) != null) {
            throw new UserHasBeenRegistedException("该用户名已注册");
        }
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.insert(user);

            return true;
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }
    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers(){
        return userDao.selectAll();
    }


}
