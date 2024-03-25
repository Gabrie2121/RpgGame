package com.game.rpg.service;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.rpg.entity.authentication.Login;
import com.game.rpg.entity.user.User;
import com.game.rpg.repository.AuthenticationRepository;
import com.game.rpg.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    private AuthenticationRepository authenticationRepository;
    

    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Login userDetails;

            userDetails = this.authenticationRepository.getUserAuthentication(username);
            return userDetails;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    

}
