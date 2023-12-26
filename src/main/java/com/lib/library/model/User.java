package com.lib.library.model;

import java.util.Set;

import org.hibernate.annotations.NaturalId;

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
    @NaturalId(mutable = true)
    @Column(name = "usermail")
    private String userMail;
    @Column(name = "password")
    private String password;
    @Column(name = "userrole")
    private String userRole;
    @Column(name = "isenabled")
    private Boolean isenabled=false;

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
        return userMail;
    }

    public void setUserMail(String UserMail) {
        userMail = UserMail;
    }

    public Set<borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(Set<borrow> borrow) {
        this.borrow = borrow;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Boolean getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Boolean isenabled) {
        this.isenabled = isenabled;
    }

    
    


}
