package com.game.rpg.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.rpg.entity.authentication.Login;
import com.game.rpg.entity.user.Me;
import com.game.rpg.entity.user.User;
import com.game.rpg.repository.UserRepository;

@Service
public class LoginService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(Login login) {
        return authenticate(login.getUsername(), login.getPassword());
    }

    public boolean authenticate(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(password, user.getPassword());
        }

        return false;
    }

    public Me findUserByUsernamegetRoles(String username) {
        return userRepository.findUserByUsernamegetRoles(username);
    }
}
