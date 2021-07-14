package com.example.demo.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MovieEntity;
@Repository
public interface MovieRepository extends MongoRepository<MovieEntity, String>{

}
