package com.example.migration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.migration.repository.mongo")
public class MongoConfig {
    // Spring Boot auto-configures MongoTemplate if properties are set
}
