package com.example.bankkata.controller;


import com.example.bankkata.model.User;
import com.example.bankkata.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/katabank/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping()
    User getUser(@PathVariable Integer userId) {
        return iUserService.getUser(userId);
    }

    @PostMapping ()
    User addUser(@RequestBody User user){
        return iUserService.addUser(user);
    }

    @PutMapping()
    User updateUser(@RequestBody  User user){
        return iUserService.updateUser(user);
    }

    @DeleteMapping()
    void deleteUser(User user){
        iUserService.deleteUser(user);
    }

    @GetMapping("/all")
    List<User> getUsers(){
        return iUserService.getUsers();
    }
}
