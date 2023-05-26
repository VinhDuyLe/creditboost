package com.creditboost.creditboostapi.controller;

import com.creditboost.creditboostapi.model.User;
import com.creditboost.creditboostapi.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl creditBoostService) {
        this.userService = creditBoostService;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long idUser) {
        User user = null;
        user = userService.getUserById(idUser);
        return ResponseEntity.ok(user) ;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long idUser) {
        Boolean deleted = false;
        deleted = userService.deleteUser(idUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long idUser, @RequestBody User user) {
        user = userService.updateUser(idUser, user);
        return ResponseEntity.ok(user);

    }

}
