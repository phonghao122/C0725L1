package com.example.ss8.service;

import com.example.ss8.dto.UserDto;
import com.example.ss8.entity.User;

public interface IUserService {
    boolean save(UserDto user);
}
