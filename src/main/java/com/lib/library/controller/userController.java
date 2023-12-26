package com.lib.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.library.model.User;
import com.lib.library.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class userController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }  
}
