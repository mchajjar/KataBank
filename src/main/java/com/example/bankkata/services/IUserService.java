package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> getUser(Integer userId);
    User addUser(User user);
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(User user) throws UserNotFoundException;
    List<User> getUsers();
}
