package com.cukhoaimon.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cukhoaimon.blog.data.Post;


public interface PostRepository extends MongoRepository<Post, String> {}
