package com.okay.security.model;

import com.okay.security.core.BaseModel;

import java.util.List;

public class UserDto extends BaseModel {

    private String name;

    private String surname;

    private String username;

    private String password;

    private List<RoleDto> roleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }
}