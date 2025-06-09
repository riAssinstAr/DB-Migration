package com.example.migration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.migration.repository.mongo.UserMongoRepository;
import com.example.migration.repository.sql.UserRepository;
import com.example.migration.model.mongo.UserDocument;
import com.example.migration.model.sql.UserEntity;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository sqlRepo;
    @Autowired
    private UserMongoRepository mongoRepo;

    @GetMapping("/api")
    public ResponseEntity<String> getProfile(@RequestHeader(value = "X-USER", required = true) String username) {
        try {
            if (username == null || username.isEmpty()) {
                return ResponseEntity.status(500).body("Internal server error");
            }
            return ResponseEntity.status(200).body("Migrated one user from SQL to MongoDB successfully!");
        } catch (Exception e) {
            logger.error("Unexpected error in /api", e);
            return ResponseEntity.status(500).body("Internal server error.");
        }
    }

    @GetMapping("/all-sql")
    public ResponseEntity<List<UserEntity>> getAllSqlUsers() {
        return ResponseEntity.ok(sqlRepo.findAll());
    }

    @GetMapping("/all-mongo")
    public ResponseEntity<List<UserDocument>> getAllMongoUsers() {
        return ResponseEntity.ok(mongoRepo.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Username and password must be provided.");
        }
        return sqlRepo.findByUsername(username)
                .<ResponseEntity<?>>map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.status(401).body("Invalid credentials."));
    }
}
