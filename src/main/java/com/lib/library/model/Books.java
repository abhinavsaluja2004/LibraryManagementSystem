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
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "bookid")
    private String BookId;
    @Column(name = "bookname")
    private String bookName;
    @Column(name = "author")
    private String Author;
    @Column(name = "edition")
    private String Edition;
    @Column(name = "category")
    private String Category;
    @Column(name = "deweydecimal")
    private float DeweyDecimal;
    @Column(name = "quantity")
    private int Quantity;
    @Column(name = "summary")
    private String Summary;
    @Column(name = "imageurl")
    private String ImageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<borrow> borrow;

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public float getDeweyDecimal() {
        return DeweyDecimal;
    }

    public void setDeweyDecimal(float deweyDecimal) {
        DeweyDecimal = deweyDecimal;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public Set<borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(Set<borrow> borrow) {
        this.borrow = borrow;
    }
}

