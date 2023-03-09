package com.vicoga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/my-cards")
    public String getCards(){
        return"cards";
    }

}
