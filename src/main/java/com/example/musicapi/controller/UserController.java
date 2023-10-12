package com.example.musicapi.controller;

import com.example.musicapi.model.User;
import com.example.musicapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Authentication authentication){
        String email = authentication.getName();
        Optional<User> user = userService.findByEmail(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
