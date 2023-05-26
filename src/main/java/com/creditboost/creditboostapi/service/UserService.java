package com.creditboost.creditboostapi.service;

import com.creditboost.creditboostapi.model.User;

import java.util.List;

public interface UserService {
    
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long idUser);

    Boolean deleteUser(Long idUser);

    User updateUser(Long idUser, User user);
}
