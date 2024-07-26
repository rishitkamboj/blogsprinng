package com.rishit.blog.repository;

import com.rishit.blog.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface UserRepo extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
