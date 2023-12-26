package com.lib.library.security;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lib.library.model.User;

import lombok.Data;

@Data
public class UserRegistrationDetails implements UserDetails{

    private String UserName;
    private String password;
    private boolean isenabled;
    private List<GrantedAuthority> authorities;

    

    public UserRegistrationDetails(User user) {
        this.UserName = user.getUserMail();
        this.password = user.getPassword();
        this.isenabled = user.getIsenabled();
        this.authorities = Arrays.stream(user.getUserRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
            return UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return isenabled;
    }
    
}
