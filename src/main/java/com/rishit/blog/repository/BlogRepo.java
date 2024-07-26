package com.rishit.blog.repository;

import com.rishit.blog.entity.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BlogRepo extends MongoRepository<Blog, ObjectId> {
}
