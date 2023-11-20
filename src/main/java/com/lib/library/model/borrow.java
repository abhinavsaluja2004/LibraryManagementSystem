package com.lib.library.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class borrow {
    
    private int id;

    private User user;
    private Books books;

    private Date borrowDate;
    private Date returnDate;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BookId", referencedColumnName = "BookId")
    public Books getBooks() {
        return books;
    }
    public void setBooks(Books books) {
        this.books = books;
    }

    @Column(name = "borrowDate")
    @Temporal(TemporalType.DATE)
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Column(name = "returnDate")
    @Temporal(TemporalType.DATE)
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    

}
