package com.game.rpg.commom.filters;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.game.rpg.commom.JwtTokenProvider;
import com.game.rpg.service.AuthenticationService;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationService autenticacaoService;

    JwtRequestFilter(JwtTokenProvider jwtTokenProvider, AuthenticationService autenticacaoService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.autenticacaoService = autenticacaoService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String nomeUsuario;
        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        nomeUsuario = jwtTokenProvider.pegarUsuarioDoToken(jwt);
        if (StringUtils.isNotEmpty(nomeUsuario) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = autenticacaoService.loadUserByUsername(nomeUsuario);
            if (jwtTokenProvider.validarToken(jwt)) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }

        filterChain.doFilter(request, response);

    }

}