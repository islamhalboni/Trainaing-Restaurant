package com.example.Restaurant.Authentication;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface AuthRepo extends MongoRepository<Auth, String> {
    Optional<Auth> findByUsername(String username);
}
