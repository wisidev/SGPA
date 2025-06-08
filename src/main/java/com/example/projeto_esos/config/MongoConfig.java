package com.example.projeto_esos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.projeto_esos.repository.mongo")
public class MongoConfig {
    
}
