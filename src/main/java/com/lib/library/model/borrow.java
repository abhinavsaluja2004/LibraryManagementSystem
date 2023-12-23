package com.lib.library.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "borrow")
public class borrow {
    
    private Integer id;

    private User user;
    private Books books;

    private Date borrowDate;
    private Date returnDate;

    private boolean isReturned;

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowid")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BookId", referencedColumnName = "BookId")
    public Books getBooks() {
        return books;
    }
    public void setBooks(Books books) {
        this.books = books;
    }
    @Column(name = "borrowdate")
    @Temporal(TemporalType.DATE)
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    @Column(name = "returndate")
    @Temporal(TemporalType.DATE)
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    @Column(name = "isreturned")
    public boolean isReturned() {
        return isReturned;
    }
    public void setReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }


}