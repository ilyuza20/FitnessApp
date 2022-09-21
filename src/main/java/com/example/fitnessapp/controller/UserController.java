package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public @ResponseBody
    User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{idUser}")
    public User getUser(@PathVariable ("idUser") Long userId) {
        return userService.getUserById(userId);
    }
}
