package com.lib.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.library.model.User;
import com.lib.library.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository UserRepository;


    @Override
    public User getUserById(String id) {
        return UserRepository.findById(id).get();
    }

    @Override
    public List<User> findByUserNameContaining(String userName) {
        return UserRepository.findByUserNameContaining(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    @Override
    public void save(User user) {
        UserRepository.save(user);
    }


}
