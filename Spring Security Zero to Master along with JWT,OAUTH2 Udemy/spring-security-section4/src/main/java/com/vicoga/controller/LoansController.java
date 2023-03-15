package com.vicoga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

@GetMapping("/my-loans")
    public String getLoansDetail(){
    return "loans";
}

}
