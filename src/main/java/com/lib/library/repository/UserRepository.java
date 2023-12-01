package com.lib.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lib.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    List<User> findByUserNameContaining(String userName);



}
