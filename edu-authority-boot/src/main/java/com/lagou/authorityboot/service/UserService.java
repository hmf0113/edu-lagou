package com.lagou.authorityboot.service;

import com.lagou.authorityboot.entity.UserDTO;

public interface UserService {
    UserDTO login(String phone, String password);

    UserDTO checkToken(String token);
}
