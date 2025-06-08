package com.example.projeto_esos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.projeto_esos.repository.h2")
public class H2Config {
    
}
