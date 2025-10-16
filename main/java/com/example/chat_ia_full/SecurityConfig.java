package com.example.chat_ia_full;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index.html", "/chat.js", "/style.css", "/ws-chat.js/**").permitAll()
                .anyRequest().permitAll()
        )
        .formLogin(login -> login.disable())
        .httpBasic(basic -> basic.disable());
    return http.build();
    }
}