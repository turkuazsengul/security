package com.okay.security.service;

import com.okay.security.model.UserDto;

public interface UserService {

    UserDto login(String username, String password);

    UserDto register(UserDto userDto);
}