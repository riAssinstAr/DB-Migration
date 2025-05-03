package com.example.migration.util;

import org.springframework.stereotype.Component;

import com.example.migration.model.mongo.UserDocument;
import com.example.migration.model.sql.UserEntity;

@Component
public class DataTransformer {
    public UserDocument transform(UserEntity entity) {
        UserDocument doc = new UserDocument();
        doc.setId(String.valueOf(entity.getId()));
        doc.setUsername(entity.getUsername());
        doc.setEmail(entity.getEmail());
        doc.setPreferences(entity.getPreferences());
        return doc;
    }
}
