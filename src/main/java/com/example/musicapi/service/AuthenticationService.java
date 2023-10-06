package com.example.musicapi.service;

import com.example.musicapi.model.User;

public interface AuthenticationService {
    User LoginAndReturnJWT(User signInRequest);

}
