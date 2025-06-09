package com.example.migration.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.migration.model.mongo.UserDocument;
import com.example.migration.model.sql.UserEntity;

@Component
public class DataTransformer {

    @Transactional
    public UserDocument transform(UserEntity entity) {
        UserDocument doc = new UserDocument();
        doc.setId(entity.getId());
        doc.setUsername(entity.getUsername());
        doc.setPassword(entity.getPassword());
        doc.setBonus(entity.getBonus());
        return doc;
    }
}
