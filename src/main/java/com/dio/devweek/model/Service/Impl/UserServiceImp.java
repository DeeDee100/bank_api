package com.dio.devweek.model.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.dio.devweek.model.User;
import com.dio.devweek.model.Service.UserService;
import com.dio.devweek.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {

        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return user;
    }

    @Override
    public User create(User userToCreate) {
        Long userId = userToCreate.getId();

        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account already exists");
        }

        if(userId!= null && userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User Exists");
        }

        userRepository.save(userToCreate);
        return userToCreate;

    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();

    }
    
}
