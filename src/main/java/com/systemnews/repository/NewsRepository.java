package com.systemnews.repository;


import com.systemnews.model.News;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by RADEK on 2016-08-30.
 */
@Repository
public interface NewsRepository extends MongoRepository<News, String> {
}
