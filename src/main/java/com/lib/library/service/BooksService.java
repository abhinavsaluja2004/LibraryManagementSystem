package com.lib.library.service;

import java.util.List;
import java.util.Optional;

import com.lib.library.model.Books;

public interface BooksService {

    List<Books> getAllBooks();

    Books getBooksById(String id);

    List<Books> findByBookNameContaining(String BookName);

    void save(Books books);




    
}
