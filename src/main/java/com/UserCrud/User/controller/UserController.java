package com.UserCrud.User.controller;

import com.UserCrud.User.Model.User;
import com.UserCrud.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @PostMapping("/users/")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> putUser(@RequestBody User user, @PathVariable Long id){
        Optional<User> temp = userRepository.findById(id);

        if(!temp.isPresent())
            return ResponseEntity.notFound().build();
        user.setId(id);
        userRepository.save(user);
//        return userRepository.getOne(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        User placeholder = userRepository.getOne(id);
        userRepository.delete(placeholder);
//        return placeholder;

    }
}
