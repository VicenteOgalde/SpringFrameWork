package com.vicoga.springcloud.mcsv.users.controllers;

import com.vicoga.springcloud.mcsv.users.models.entities.User;
import com.vicoga.springcloud.mcsv.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<User> optionalUser= userService.findById(id);
        if(optionalUser.isPresent()){
            return ResponseEntity.ok().body(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }
}
