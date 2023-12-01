package com.lib.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.library.model.Books;
import com.lib.library.model.User;
import com.lib.library.model.borrow;
import com.lib.library.service.BooksService;
import com.lib.library.service.BorrowService;
import com.lib.library.service.UserService;

@RestController
@RequestMapping("/library_test")
@CrossOrigin
public class libcontroller {

    @Autowired
    private UserService UserService;

    @Autowired
    private BooksService BooksService;

    @Autowired
    private BorrowService BorrowService;  
    
    @PostMapping("/adduser")
    public String saveUserData(@RequestBody User user){
        UserService.save(user);
        return "New user added";
    }

    @PostMapping("/addborrow")
    public String saveBorrowData(@RequestBody borrow borrow){
        BorrowService.save(borrow);
        return "borrow data added";
    }

    

    @PostMapping("/addbook")
    public String saveBooksData(@RequestBody Books Books){
        BooksService.save(Books);
        return "New Book added";
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return UserService.getAllUsers();
    }
    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return BooksService.getAllBooks();
    }

    @GetMapping("/borrow")
    public List<borrow> getAllBorrow() {
        return BorrowService.getAllBorrow();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return UserService.getUserById(id);
    }

    @GetMapping("/books/{id}")
    public Books getBooksById(@PathVariable String id) {
        return BooksService.getBooksById(id);
    }

    @GetMapping("/books/bookname/{bookname}")
    public List<Books> findBooksContainingByBookName(@PathVariable String bookname) {
        return BooksService.findByBookNameContaining(bookname);
    }

    @GetMapping("/users/username/{userName}")
    public List<User> findUsersContainingByUserName(@PathVariable String userName){
        return UserService.findByUserNameContaining(userName);
    }

    @GetMapping("/books/countbooks")
    public long countBooks() {
        return BooksService.countBooks();
    }

    @DeleteMapping("/books/deletebooks/{id}")
    public String deleteBooksById(@PathVariable String id) {
        BooksService.deleteBooksById(id);
        return "Book deleted with id : " + id;
    }

    @DeleteMapping("/users/deleteusers/{id}")
    public String deleteUsersById(@PathVariable String id) {
        UserService.deleteUsersById(id);
        return "User deleted with id : " + id;
    }
}
