package com.example.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.example.migration.model.mongo.UserDocument;
import com.example.migration.repository.mongo.UserMongoRepository;
import com.example.migration.repository.sql.UserRepository;
import com.example.migration.util.DataTransformer;

@Service
public class MigrationService {

    private static final Logger logger = LoggerFactory.getLogger(MigrationService.class);

    @Autowired
    private UserRepository sqlRepo;
    @Autowired
    private UserMongoRepository mongoRepo;
    @Autowired
    private DataTransformer transformer;

    @Async
    public void migrateIfNeeded(String username) {
        logger.info("Checking if migration is needed for user: " + username);
        if (mongoRepo.findByUsername(username).isPresent()) {
            logger.info("User already exists in MongoDB. Skipping migration.");
            return;
        }

        sqlRepo.findByUsername(username).ifPresentOrElse(sqlUser -> {
            logger.info("Migrating one user from SQL to MongoDB.");
            UserDocument doc = transformer.transform(sqlUser);
            mongoRepo.save(doc);
            logger.info("Migration completed for user: " + username);
        }, () -> {
            logger.info("User not found in SQL database.");
        });
    }
}
