package com.creditboost.creditboostapi.service;

import com.creditboost.creditboostapi.entity.UserEntity;
import com.creditboost.creditboostapi.model.User;
import com.creditboost.creditboostapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity(
                user.getUsername(), this.passwordEncoder.encode(user.getPassword()), user.getEmail()
        );

        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities
                                    .stream()
                                    .map(userEntity -> new User (
                                            userEntity.getIdUser(),
                                            userEntity.getUsername(),
                                            userEntity.getPassword(),
                                            userEntity.getEmail()
                                    )).collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(Long idUser) {
        User user = new User();
        UserEntity userEntity = userRepository.findById(idUser).get();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public Boolean deleteUser(Long idUser) {
        UserEntity userEntity = userRepository.findById(idUser).get();
        userRepository.delete(userEntity);
        return true;
    }

    @Override
    public User updateUser(Long idUser, User user) {
        UserEntity userEntity = userRepository.findById(idUser).get();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);
        return user;
    }
}
