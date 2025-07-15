// src/main/java/com/cognizant/jwt/config/SecurityConfig.java
package com.cognizant.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/authenticate").authenticated()  // ✅ require login
                .anyRequest().permitAll()
            )
            .httpBasic()  // enable HTTP Basic Auth
            .and()
            .csrf().disable(); // disable CSRF for simplicity
        return http.build();
    }
}
