package com.lib.library.service;

import java.util.*;
import com.lib.library.model.User;
import com.lib.library.registration.RegistrationRequest;
import com.lib.library.registration.token.VerificationToken;


public interface UserService {



    User getUserById(Long id);

    List<User> findByUserNameContaining(String userName);

    List<User> getAllUsers();

    void save(User user);

    void deleteUsersById(Long id);

    Optional<User> findByUserMail(String userMail);

    User registerUser(RegistrationRequest request);

    void saveUserVerificationToken(User theUser, String verificationToken);

    String validateToken(String theToken);



    
}