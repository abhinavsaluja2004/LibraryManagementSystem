package com.lib.library.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lib.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByUserNameContaining(String userName);

    Optional<User> findByUserMail(String userMail);



}
