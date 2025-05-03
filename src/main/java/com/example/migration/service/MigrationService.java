package com.example.migration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.migration.model.mongo.UserDocument;
import com.example.migration.repository.mongo.UserMongoRepository;
import com.example.migration.repository.sql.UserRepository;
import com.example.migration.util.DataTransformer;

@Service
public class MigrationService {

    @Autowired private UserRepository sqlRepo;
    @Autowired private UserMongoRepository mongoRepo;
    @Autowired private DataTransformer transformer;

    public void migrateIfNeeded(String username) {
        System.out.println("Checking if migration is needed for user: " + username);
        if (mongoRepo.findByUsername(username).isPresent()) {
            System.out.println("User already exists in MongoDB. Skipping migration.");
            return;
        }

        sqlRepo.findByUsername(username).ifPresentOrElse(sqlUser -> {
            System.out.println("Migrating user from SQL to MongoDB.");
            UserDocument doc = transformer.transform(sqlUser);
            mongoRepo.save(doc);
            System.out.println("Migration completed for user: "+ username);
        }, () -> {
            System.out.println("User not found in SQL database.");
        });
    }
}
