package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.dto.PetugasDto;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.service.PetugasService;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class PetugasController {

    @Autowired
    PetugasService petugasService;

    @Autowired
    PetugasRepository petugasRepository;

    @GetMapping("/cms/list_petugas")
    public String viewPetugas(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);
        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        model.addAttribute("listPetugas", petugasService.getAllPetugas());
        model.addAttribute("petugas", new Petugas());
        return "cms/list_petugas";
    }

    @GetMapping("/showPetugasById")
    @ResponseBody
    public Petugas showPetugasById(long nip){
        return petugasService.getPetugasById(nip);
    }

    @PostMapping("/updatePetugas")
    public String updatePetugas(@ModelAttribute("petugas") PetugasDto petugasDto) throws IOException {

        String status = "successUpdate";
        try {
            petugasService.updatePetugas(petugasDto.getNama(), petugasDto.getJenisKelamin(),
                    petugasDto.getNoHp(), petugasDto.getEmail(), petugasDto.getJabatan(),
                    petugasDto.getStatusPetugas(), petugasDto.getNip());
        }catch (Exception e){
            status = "failedUpdate";
        }

        return "redirect:/cms/list_petugas?" + status;
    }

    @PostMapping("/updatePetugasProfile")
    public String updatePetugasProfile(@ModelAttribute("petugas") PetugasDto petugasDto) throws IOException {

        String status = "successProfile";
        try {
            petugasService.updateProfile(petugasDto.getNama(), petugasDto.getJenisKelamin(),
                    petugasDto.getNoHp(), petugasDto.getEmail(), petugasDto.getNip());
        }catch (Exception e){
            status = "failedProfile";
        }
        return "redirect:/cms?" + status;
    }

    @GetMapping("/deletePetugasById")
    public String deletePetugasById(@RequestParam("nip") long nip){
        String status = "successDelete";
        try {
            petugasService.deletePetugasById(nip);
        }catch (Exception e){
            status = "failedDelete";
        }

        return "redirect:/cms/list_petugas?" + status;
    }
}
