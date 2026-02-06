package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/sayHi")
    String sayHello(){
        return "Backend chalu hogaya";
    }
}
