package com.game.rpg.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.rpg.entity.user.User;
import com.game.rpg.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.createUser(user);
        
    }
}
