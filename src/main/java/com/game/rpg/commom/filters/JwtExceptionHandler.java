package com.game.rpg.commom.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtExceptionHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            filterChain.doFilter(request, response);
        } catch (SignatureException ex) {
            response.setContentType("application/json;charset=UTF-8");

            ObjectMapper objectMapper = new ObjectMapper();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter w = response.getWriter();
            w.write(StringUtils.toEncodedString(
                    objectMapper.writeValueAsString("Autenticação obrigatória").getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8));
            w.flush();
        }
    }
}
