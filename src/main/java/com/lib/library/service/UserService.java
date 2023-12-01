package com.lib.library.service;

import java.util.*;
import com.lib.library.model.User;


public interface UserService {



    User getUserById(String id);

    List<User> findByUserNameContaining(String userName);

    List<User> getAllUsers();

    void save(User user);

    void deleteUsersById(String id);



    
}