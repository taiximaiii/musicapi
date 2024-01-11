package com.example.musicapi.service;

import com.example.musicapi.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByEmail(String email);
    User updateUser(Long id,User user);
}
