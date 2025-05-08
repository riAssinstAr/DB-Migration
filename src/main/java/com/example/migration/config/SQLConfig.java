package com.example.migration.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.migration.repository.sql")
@EntityScan("com.example.migration.model.sql")
public class SQLConfig {
}
