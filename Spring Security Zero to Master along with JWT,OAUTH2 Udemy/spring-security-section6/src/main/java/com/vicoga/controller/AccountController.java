package com.vicoga.controller;

import com.vicoga.model.Account;
import com.vicoga.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository repository;

    @GetMapping("/my-account")
    public Account getAccountDetails(@RequestParam("id")int id){

        Account account = repository.findByCustomerId(id);
        if (account != null ) {
            return account;
        }else {
            return null;
        }
    }

}
