package com.vannou.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class adminController {

    @GetMapping("/secret-bases")
    public RedirectView  admin() {
        return new RedirectView("https://www.wildcodeschool.com/fr-FR");
    }

}
