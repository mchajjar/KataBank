package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    User getUser(Integer userId);
    User addUser(User user);
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(User user) throws UserNotFoundException;
    List<User> getUsers();
}
