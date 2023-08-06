package com.skypro.home.service;

import com.skypro.home.model.User;
import com.skypro.home.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {

        userRepository.save(user);
    }

    public boolean existsByUsername(String userName) {

        return userRepository.existsUserByUserName(userName);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
