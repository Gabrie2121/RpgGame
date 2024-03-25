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

        if (userRepository.userExists(user.getUsername())) {
            System.out.println("teste");
            throw new RuntimeException("O Usuário já existe.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.createUser(user);

    }
}
