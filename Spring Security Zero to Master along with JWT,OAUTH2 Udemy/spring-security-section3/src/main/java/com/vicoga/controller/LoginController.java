package com.vicoga.controller;

import com.vicoga.model.Customer;
import com.vicoga.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository repository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer saveCustomer=null;
        ResponseEntity response=null;
        try{
            saveCustomer=repository.save(customer);
            if(saveCustomer.getId()>0){
                response=ResponseEntity.status(HttpStatus.CREATED)
                        .body("User successfully created.");
            }
        }catch (Exception e){
            response=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to "+e.getMessage());
        }
        return response;

    }


}
