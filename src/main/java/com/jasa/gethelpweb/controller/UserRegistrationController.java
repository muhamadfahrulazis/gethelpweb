package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.dto.UserRegistrationDto;
import com.jasa.gethelpweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms/registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "cms/register";
    }

    @PostMapping
    public String registrationAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto){
        String status = "success";
        try {
            userService.save(userRegistrationDto);
        }catch (Exception e){
            status = "failed";
        }
        return "redirect:/registration?" + status;
    }
}
