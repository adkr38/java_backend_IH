package com.adkr38.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adkr38.app.repositories.RoleRepository;
import com.adkr38.app.repositories.UserRepository;
import com.adkr38.app.models.*;
import com.adkr38.app.services.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api")
class UserController{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;


  @GetMapping("/hello")
  ResponseEntity<String> helloWorld(){
    return ResponseEntity.status(200).body("Hello world!");
  }

  @PostMapping("create-user")
  ResponseEntity<String> createUser(@RequestBody User user){
    boolean createdUser = userService.createUser(user);

    if (createdUser){
      return ResponseEntity.status(409).body("Conflict: user already exists.");
    }

    return ResponseEntity.status(201).body("Success: User created.");


  }

}

