package com.devguimsjesus.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devguimsjesus.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
