package com.dio.devweek.model.Service;

import java.util.List;

import com.dio.devweek.model.User;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User create(User userToCreate);
}
