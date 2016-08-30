package com.systemnews.repository;

import com.systemnews.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by RADEK on 2016-08-30.
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
