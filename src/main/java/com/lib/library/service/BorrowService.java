package com.lib.library.service;

import java.util.List;


import com.lib.library.model.borrow;

public interface BorrowService {

    List<borrow> getAllBorrow();

    void save(borrow borrow);

    
}
