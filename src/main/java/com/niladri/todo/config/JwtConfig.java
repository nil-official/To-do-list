package com.niladri.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Value("${jwt.expiration.time}")
    private long jwtExpirationTime;

    @Value("${jwt.token.prefix}")
    private String jwtTokenPrefix;

    @Bean
    public String jwtSecretKey() {
        return jwtSecretKey;
    }

    @Bean
    public long jwtExpirationTime() {
        return jwtExpirationTime;
    }

    @Bean
    public String jwtTokenPrefix() {
        return jwtTokenPrefix;
    }
}