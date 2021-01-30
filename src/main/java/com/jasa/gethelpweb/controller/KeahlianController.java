package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Keahlian;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.KeahlianCalonMitraRepository;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.service.KeahlianService;
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
public class KeahlianController {
    @Autowired
    KeahlianService keahlianService;

    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    KeahlianCalonMitraRepository keahlianCalonMitraRepository;

    @PostMapping("/cms/add_update_keahlian")
    public String addUpdateKeahlian(@ModelAttribute("keahlian") Keahlian keahlian) throws IOException {
        keahlianService.save(keahlian);

        String status = "";
        try {
            if (keahlian.getId_keahlian() == 0){
                status = "success";
            }else {
                status = "successUpdate";
            }
            keahlianService.save(keahlian);
        }catch (Exception e){
            if (keahlian.getId_keahlian() == 0){
                status = "failed";
            }else {
                status = "failedUpdate";
            }
        }
        return "redirect:/cms/list_keahlian?" + status ;
    }

    @GetMapping("/cms/list_keahlian")
    public String viewKeahlian(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);
        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        model.addAttribute("listKeahlian", keahlianService.getAllKeahlian());
        model.addAttribute("keahlian", new Keahlian());
        return "cms/list_keahlian";
    }

    @GetMapping("/showKeahlianById")
    @ResponseBody
    public Keahlian showKeahlianById(long id_keahlian){
        return keahlianService.getKeahlianById(id_keahlian);
    }

    @GetMapping("/deleteKeahlianById")
    public String deleteKeahlianById(@RequestParam("id_keahlian") long id_keahlian){

        String status = "successDelete";
        try {
            keahlianCalonMitraRepository.deleteKeahlianFirst(id_keahlian);
            keahlianService.deleteKeahlianById(id_keahlian);
        }catch (Exception e){
            status = "failedDelete";
        }

        return "redirect:/cms/list_keahlian?" + status;
    }
}
