package com.lib.library.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lib.library.exception.UserAlreadyExistsException;
import com.lib.library.model.User;
import com.lib.library.registration.RegistrationRequest;
import com.lib.library.registration.token.VerificationToken;
import com.lib.library.registration.token.VerificationTokenRepository;
import com.lib.library.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{


    private final UserRepository UserRepository;

    private final PasswordEncoder passwordEncoder;

    private final VerificationTokenRepository tokenRepository;

    @Override
    public User getUserById(Long id) {
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

    @Override
    public void deleteUsersById(Long id) {
        UserRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUserMail(String userMail) {
        return UserRepository.findByUserMail(userMail);
    }

    @Override
    public User registerUser(@RequestBody RegistrationRequest request) {
        Optional<User> user = this.findByUserMail(request.userMail());
        if(user.isPresent()) {
            throw new UserAlreadyExistsException("User with email "+request.userMail()+" already exists");

        }
        var newUser = new User();
        //newUser.setUserId(request.UserId());
        newUser.setUserName(request.UserName());
        newUser.setUserPhno(request.UserPhno());
        newUser.setUserMail(request.userMail());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setUserRole(request.UserRole());
        return UserRepository.save(newUser);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String Token) {
        var verificationToken = new VerificationToken(Token, theUser);
        tokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null) {
            return "Invalid Token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if(token.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0) {
            return "Token Expired";
        }
        user.setIsenabled(true);
        UserRepository.save(user);
        return "valid";
    }


}
