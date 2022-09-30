package com.example.bankkata.services;

import com.example.bankkata.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserService {

    User getUser(Integer userId);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    List<User> getUsers();
}
