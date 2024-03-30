package com.example.Restaurant.Database;

import com.example.Restaurant.User.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReop extends MongoRepository<UserModel, Integer> {

}
