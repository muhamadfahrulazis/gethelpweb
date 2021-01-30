package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.Peralatan;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.service.PeralatanService;
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
public class PeralatanController {
    @Autowired
    PeralatanService peralatanService;

    @Autowired
    PetugasRepository petugasRepository;

    @PostMapping("/cms/add_update_peralatan")
    public String addUpdatePeralatan(@ModelAttribute("peralatan") Peralatan peralatan) throws IOException {
        peralatanService.save(peralatan);
        return "redirect:/cms/list_peralatan";
    }

    @GetMapping("/cms/list_peralatan")
    public String viewPeralatan(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);
        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        model.addAttribute("listPeralatan", peralatanService.getAllPeralatan());
        model.addAttribute("peralatan", new Peralatan());
        return "cms/list_peralatan";
    }

    @GetMapping("/showPeralatanById")
    @ResponseBody
    public Peralatan showPeralatanById(long id_peralatan){
        return peralatanService.getPeralatanById(id_peralatan);
    }

    @GetMapping("/deletePeralatanById")
    public String deletePeralatanById(@RequestParam("id_peralatan") long id_peralatan){
        peralatanService.deletePeralatanById(id_peralatan);

        return "redirect:/cms/list_peralatan";
    }
}
