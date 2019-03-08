package com.arch.security.utils;

import com.arch.security.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    public static User getCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
