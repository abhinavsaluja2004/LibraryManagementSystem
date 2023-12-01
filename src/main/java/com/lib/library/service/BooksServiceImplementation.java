package com.lib.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.library.model.Books;
import com.lib.library.repository.BooksRepository;

@Service
public class BooksServiceImplementation implements BooksService{

    @Autowired
    private BooksRepository BooksRepository;

    @Override
    public List<Books> getAllBooks() {
        return BooksRepository.findAll();
    }

    @Override
    public Books getBooksById(String id) {
        if(BooksRepository.findById(id).isPresent()){
            return BooksRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Books> findByBookNameContaining(String BookName) {
        return BooksRepository.findByBookNameContaining(BookName);
    }

    @Override
    public void save(Books books) {
        BooksRepository.save(books);
    }

    @Override
    public void deleteBooksById(String id) {
        BooksRepository.deleteById(id);
    }
    //count distinct books
    @Override
    public long countBooks() {
        return BooksRepository.count();
    }

}
