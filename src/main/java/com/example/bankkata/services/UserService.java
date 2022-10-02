package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.model.User;
import com.example.bankkata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
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
        user.setCreationDate(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User existingUser = getUser(user.getCin());
        try{
            existingUser.setModificationDate(LocalDate.now());
            return addUser(existingUser);
        }catch (EntityNotFoundException entityNotFoundException){
            throw new UserNotFoundException("The user : CIN = "+user.getCin() + "doens't exists"  );
        }
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
        try{
            userRepository.deleteById(user.getCin());
        }catch (InvalidDataAccessApiUsageException invalidDataAccessApiUsageException){
            throw new UserNotFoundException("The user : CIN = "+user.getCin() + "doens't exists"  );
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
