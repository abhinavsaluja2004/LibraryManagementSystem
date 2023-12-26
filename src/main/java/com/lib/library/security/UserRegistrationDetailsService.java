package com.lib.library.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lib.library.model.User;
import com.lib.library.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String UserMail) throws UsernameNotFoundException {
        return userRepository.findByUserMail(UserMail).map(UserRegistrationDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
    
}
