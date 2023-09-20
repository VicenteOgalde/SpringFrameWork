package com.vicoga.springcloud.mcsv.users.controllers;

import com.vicoga.springcloud.mcsv.users.models.entities.User;
import com.vicoga.springcloud.mcsv.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user,@PathVariable Long id){
        Optional<User> optionalUser= userService.findById(id);
        if(optionalUser.isPresent()){
            User userDB= optionalUser.get();
            userDB.setName(user.getName());
            userDB.setEmail(user.getEmail());
            userDB.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<User> optionalUser=userService.findById(id);
        if(optionalUser.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
