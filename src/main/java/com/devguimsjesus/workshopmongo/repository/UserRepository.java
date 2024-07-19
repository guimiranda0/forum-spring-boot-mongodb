package com.devguimsjesus.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.devguimsjesus.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
