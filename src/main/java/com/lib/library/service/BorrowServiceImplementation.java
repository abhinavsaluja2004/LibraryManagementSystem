package com.lib.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.library.model.borrow;
import com.lib.library.repository.BorrowRepository;

@Service
public class BorrowServiceImplementation implements BorrowService{
    

    @Autowired
    private BorrowRepository BorrowRepository;

    @Override
    public List<borrow> getAllBorrow() {
        return BorrowRepository.findAll();
    }

    @Override
    public void save(borrow borrow) {
        BorrowRepository.save(borrow);
    }

}
