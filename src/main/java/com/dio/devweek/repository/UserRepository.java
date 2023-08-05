package com.dio.devweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.devweek.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByAccountNumber(String accountNumber);
}
