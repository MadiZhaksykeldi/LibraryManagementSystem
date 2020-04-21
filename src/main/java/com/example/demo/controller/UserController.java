package com.example.demo.controller;

import com.example.demo.user.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/create")
    public void createUserByUsernamePassword(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userService.createUser(user);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);
        userService.createUser(user);
    }

    @PutMapping("/{Id}")
    public void updateUser(@PathVariable Long Id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("Id = " + Id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(Id, user);
    }
}