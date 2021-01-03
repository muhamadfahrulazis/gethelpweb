package com.jasa.gethelpweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/cms/login")
    public String login(){
        return "cms/login";
    }

    @GetMapping("/cms")
    public String cms(){
        return "cms/home";
    }
}
