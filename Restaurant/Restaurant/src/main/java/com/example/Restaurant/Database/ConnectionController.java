package com.example.Restaurant.Database;


import com.example.Restaurant.User.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectionController {
    @Autowired
    UserReop userReop;
    @PostMapping("/addUser")
    public void addUser(@RequestBody UserModel user){
        userReop.save(user);
    }

    @GetMapping("getUser/{id}")
    public UserModel getUserById(@PathVariable Integer id){
       return userReop.findById(id).orElse(null);
    }

    @GetMapping("/getUsers")
    public List<UserModel> getAllUsers() {
        return userReop.findAll();
    }
}
