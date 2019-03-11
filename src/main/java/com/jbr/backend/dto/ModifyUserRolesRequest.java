package com.jbr.backend.dto;

import java.util.List;

public class ModifyUserRolesRequest {
    private Integer userId;

    private List<Integer> roleIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
