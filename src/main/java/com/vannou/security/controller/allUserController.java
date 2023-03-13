package com.vannou.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class allUserController {
    @GetMapping("/")
    public String indexAllUser() {
        return "Welcome to the SHIELD";
    }
}
