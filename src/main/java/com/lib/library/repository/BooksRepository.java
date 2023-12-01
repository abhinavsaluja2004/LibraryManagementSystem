package com.lib.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.library.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, String>{

    List<Books> findByBookNameContaining(String BookName);



}
