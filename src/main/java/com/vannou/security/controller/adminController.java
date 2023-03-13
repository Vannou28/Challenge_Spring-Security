package com.vannou.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class adminController {

    @GetMapping("/secret-bases")
    public String []  admin() {
        String [] citiesWild = {"Biarritz",
        "Bordeaux",
        "La Loupe",
        "Lille",
        "Lyon",
        "Nantes",
        "Orléans",
        "Paris",
        "Reims",
        "Strasbourg",
        "Toulouse"};
        return citiesWild ;
    }

}
