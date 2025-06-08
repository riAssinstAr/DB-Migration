package com.example.migration.repository.mongo;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.migration.model.mongo.UserDocument;

@Transactional
public interface UserMongoRepository extends MongoRepository<UserDocument, Integer> {
    Optional<UserDocument> findByUsername(String username);
}
