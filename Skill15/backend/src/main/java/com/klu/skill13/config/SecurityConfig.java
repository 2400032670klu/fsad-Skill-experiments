package com.klu.skill13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // ✅ disable csrf completely
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   // ✅ TEMP allow everything
            )
            .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}