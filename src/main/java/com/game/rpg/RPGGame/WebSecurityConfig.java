package com.game.rpg.RPGGame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.game.rpg.commom.filters.JwtExceptionHandler;
import com.game.rpg.commom.filters.JwtRequestFilter;
import com.game.rpg.service.AuthenticationService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    private AuthenticationService authenticationService;
    private JwtRequestFilter jwtRequestFilter;
    private JwtExceptionHandler exceptionHandler;

    public WebSecurityConfig(AuthenticationService authenticationService, JwtRequestFilter jwtRequestFilter,
            JwtExceptionHandler exceptionHandler) {
        this.authenticationService = authenticationService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.exceptionHandler = exceptionHandler;

    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(HttpMethod.POST, "api/users/register").permitAll()
                .requestMatchers(HttpMethod.POST, "api/login").permitAll()
                .requestMatchers(HttpMethod.GET, "api/users/teste").permitAll()
                .anyRequest().authenticated())
                .csrf((csrf) -> csrf.disable())
                .cors((cors) -> cors.configurationSource(corConfig()))
                .authenticationProvider(authenticationProvider())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionHandler, jwtRequestFilter.getClass())
                .exceptionHandling((ex) -> ex.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.NOT_FOUND)));

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(authenticationService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    CorsConfigurationSource corConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.PATCH);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.HEAD);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
