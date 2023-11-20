package com.lib.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.library.model.borrow;

@Repository
public interface BorrowRepository extends JpaRepository<borrow, Integer>{

    
}
