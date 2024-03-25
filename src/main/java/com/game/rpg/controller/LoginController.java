package com.game.rpg.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.rpg.commom.JwtTokenProvider;
import com.game.rpg.entity.authentication.Login;
import com.game.rpg.service.AuthenticationService;
import com.game.rpg.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginController(LoginService loginService, AuthenticationService authenticationService,
            JwtTokenProvider jwtTokenProvider) {
        this.loginService = loginService;
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        boolean loginSuccessful = loginService.login(login);

        if (loginSuccessful) {
            UserDetails userDetails = authenticationService.loadUserByUsername(login.getUsername());
            String token = jwtTokenProvider.criarToken(userDetails);
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @GetMapping("/me")
    public ResponseEntity<?> me(HttpServletRequest request) {
        String token = extractToken(request);
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token não fornecido");
        }
        boolean validado = jwtTokenProvider.validarToken(token);

        HashMap<String, String> hash = new HashMap<String, String>();

        hash.put("token", token);
        hash.put("username", jwtTokenProvider.pegarUsuarioDoToken(token));
        hash.put("validado?", validado == true ? "Sim" : "Não");

        return ResponseEntity.ok().body(hash);
    }

    private String extractToken(HttpServletRequest request) {
        // Obter o cabeçalho Authorization da solicitação
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // O token JWT é a parte após "Bearer "
            return authHeader.substring(7);
        }
        return null;
    }
}
