package com.enes.service;

import com.enes.entity.User;
import com.enes.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User login(String email, String password){
        return userRepository.login(email, password);
    }
}
