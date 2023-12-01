package com.lib.library.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userid")
    private String UserId;
    @Column(name = "username")
    private String userName;
    @Column(name = "userphno")
    private long UserPhno;
    @Column(name = "usermail")
    private String UserMail;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<borrow> borrow;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserPhno() {
        return UserPhno;
    }

    public void setUserPhno(long userPhno) {
        UserPhno = userPhno;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }

    public Set<borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(Set<borrow> borrow) {
        this.borrow = borrow;
    }

    
    


}
