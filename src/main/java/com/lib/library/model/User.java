package com.lib.library.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "user")
public class User {
    @Id
    private String UserId;
    private String userName;
    private long UserPhno;
    private String UserMail;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "borrow",
    joinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false, updatable = false)
    
    },

    inverseJoinColumns = {
        @JoinColumn(name = "BookId", referencedColumnName = "BookId", nullable = false, updatable = false)
    }
    )
    private Set<Books> books;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
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

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }


    


}
