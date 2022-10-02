package com.example.bankkata.services;

import com.example.bankkata.exception.CustomException;
import com.example.bankkata.exception.UserException.InvalideDataUserException;
import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.exception.accountException.AccountExistingException;
import com.example.bankkata.model.User;
import com.example.bankkata.repository.UserRepository;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    private boolean isUserFound(Integer userId){
        boolean exists = false;
        try{
            userRepository.findById(userId).get();
        }catch (NoSuchElementException e){
            return  exists;
        }
        return !exists;
    }

    @Override
    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User addUser(User user) {
        if (isUserFound(user.getCin())){
            throw new UserNotFoundException("The user= "+user.getCin() + " exists"  );
        }
        try{
            user.setCreationDate(LocalDate.now());
            return userRepository.save(user);
        }catch (InvalidDataAccessApiUsageException e){
            throw new InvalideDataUserException(e.getMessage());
        }
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        User existingUser;
        if (!isUserFound(user.getCin())){
            throw new UserNotFoundException("The user= "+user.getCin() + "does not exists"  );
        }
        try{
            existingUser = getUser(user.getCin()).get();
            existingUser.setModificationDate(LocalDate.now());
            return addUser(existingUser);
        }catch (InvalidDataAccessApiUsageException e){
            throw new InvalideDataUserException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
        if (!isUserFound(user.getCin())){
            throw new UserNotFoundException("The user= "+user.getCin() + "does not exists"  );
        }
        try{
            userRepository.deleteById(user.getCin());
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<User> getUsers() {
        try{
            return userRepository.findAll();
        }catch (Exception e){
            throw e;
        }
    }
}
