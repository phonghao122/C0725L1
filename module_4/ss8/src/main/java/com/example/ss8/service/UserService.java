package com.example.ss8.service;

import com.example.ss8.dto.UserDto;
import com.example.ss8.entity.User;
import com.example.ss8.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean save(UserDto user) {
        if (user != null){
            User newUser = new User();
            BeanUtils.copyProperties(user, newUser);
            userRepository.save(newUser);
            return true;
        }
        return false;
    }
}
