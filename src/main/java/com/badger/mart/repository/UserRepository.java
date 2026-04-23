package com.badger.mart.repository;

import com.badger.mart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , String> {

    public User findByUsername(String username);
}
