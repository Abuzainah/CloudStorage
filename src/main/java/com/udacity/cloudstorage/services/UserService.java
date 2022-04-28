package com.udacity.cloudstorage.services;

import com.udacity.cloudstorage.Mappers.UserMapper;
import com.udacity.cloudstorage.Models.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private UserMapper userMapper;
    private HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean doesUserNameExists(String username){
        return userMapper.getUserByName(username) != null;
    }

    public int createUser(User user){
        SecureRandom secureRandom = new SecureRandom();
        byte [] salt = new byte[16];
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword() , encodedSalt);
        return userMapper.insertUser(user);
    }

}
