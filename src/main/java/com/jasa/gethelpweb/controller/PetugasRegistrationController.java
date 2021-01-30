package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.dto.PetugasDto;
import com.jasa.gethelpweb.service.PetugasService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms/registration")
public class PetugasRegistrationController {

    private final PetugasService petugasService;

    public PetugasRegistrationController(PetugasService petugasService) {
        super();
        this.petugasService = petugasService;
    }

    @ModelAttribute("petugas")
    public PetugasDto userRegistrationDto(){
        return new PetugasDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "cms/list_petugas";
    }

    @PostMapping
    public String registrationAccount(@ModelAttribute("petugas") PetugasDto petugasDto){
        String status = "success";
        try {
            petugasService.save(petugasDto);
        }catch (Exception e){
            status = "failed";
        }
        return "redirect:/cms/list_petugas?" + status;
    }
}
