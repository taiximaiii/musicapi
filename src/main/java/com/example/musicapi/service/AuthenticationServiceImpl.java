package com.example.musicapi.service;

import com.example.musicapi.model.User;
import com.example.musicapi.security.UserPrincipal;
import com.example.musicapi.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    @Override
    public User LoginAndReturnJWT(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        String jwt = jwtProvider.generateToken(userPrincipal);
        User registerUser = userPrincipal.getUser();
        registerUser.setToken(jwt);
        return registerUser;
    }

}
