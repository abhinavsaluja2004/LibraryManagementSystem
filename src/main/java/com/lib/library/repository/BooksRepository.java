package com.lib.library.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lib.library.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, String>{

    List<Books> findByBookNameContaining(String BookName);



}
