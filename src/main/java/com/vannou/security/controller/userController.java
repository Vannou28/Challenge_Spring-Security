package com.vannou.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @GetMapping("/avengers/assemble")
    public String indexUser() {
        return "Avengers... Assemble";
    }
    
}
