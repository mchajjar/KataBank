package com.example.bankkata.services;

import com.example.bankkata.model.User;
import com.example.bankkata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User getUser(Integer userId) {
        return userRepository.getReferenceById(userId);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = getUser(user.getCin());
        return addUser(user);
    }

    @Override
    public void deleteUser(User user) {
         userRepository.deleteById(user.getCin());
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
