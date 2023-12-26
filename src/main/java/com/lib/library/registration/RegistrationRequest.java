package com.lib.library.registration;

public record RegistrationRequest(String UserId, String UserName, long UserPhno, String userMail, String password, String UserRole) {
    
}
