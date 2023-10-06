package com.vicoga.springcloud.mcsv.users.controllers;

import com.vicoga.springcloud.mcsv.users.models.entities.User;
import com.vicoga.springcloud.mcsv.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){
        if(userService.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("message","already exist an user with this email ".concat(user.getEmail())));
        }
        if(result.hasErrors()){
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody User user, BindingResult result, @PathVariable Long id){

        if (result.hasErrors()){
            return validation(result);
        }

        Optional<User> optionalUser= userService.findById(id);
        if(optionalUser.isPresent()){
            User userDB= optionalUser.get();
            if(!user.getEmail().equalsIgnoreCase(userDB.getEmail()) && userService.findByEmail(user.getEmail()).isPresent()){
                return ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("message","already exist an user with this email ".concat(user.getEmail())));
            }

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

    private static ResponseEntity<Map<String, String>> validation(BindingResult result) {
        Map<String,String>errors= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errors.put(err.getField(),"The field ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }



}
