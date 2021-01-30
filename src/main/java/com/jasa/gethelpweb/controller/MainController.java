package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import com.jasa.gethelpweb.repository.CalonMitraRepository;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.repository.ProsesCalonMitraRepository;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    CalonMitraRepository calonMitraRepository;

    @Autowired
    ProsesCalonMitraRepository prosesCalonMitraRepository;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/getclean")
    public String getClean(){
        return "getclean_page";
    }

    @GetMapping("/getmassage")
    public String getMassage(){
        return "getmassage_page";
    }

    @GetMapping("/getbeauty")
    public String getBeauty(){
        return "getbeauty_page";
    }

    @GetMapping("/faq")
    public String faq(){
        return "faq";
    }

    @GetMapping("/403")
    public String error403(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        System.out.println("TEST" + userDetails.getAuthorities());
        Petugas petugas = petugasRepository.findByEmail(userDetails.getUsername());
        model.addAttribute("user", petugas);
        return "/error/403";
    }

    @GetMapping("/cms/login")
    public String login(){
        return "cms/login";
    }

    @GetMapping("/cms")
    public String cms(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);

        int totalCalonMitraBaru = calonMitraRepository.getTotalCalonMitraBaru();
        int totalCalonMitraTraining = prosesCalonMitraRepository.getTotalCalonMitraTraining();
        int totalCalonMitraOnboarding = prosesCalonMitraRepository.getTotalCalonMitraOnboarding();
        int totalCalonMitraGagal = prosesCalonMitraRepository.getTotalCalonMitraGagal();

        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));

        model.addAttribute("totalCalonMitraBaru", totalCalonMitraBaru);
        model.addAttribute("totalCalonMitraTraining", totalCalonMitraTraining);
        model.addAttribute("totalCalonMitraOnboarding", totalCalonMitraOnboarding);
        model.addAttribute("totalCalonMitraGagal", totalCalonMitraGagal);
        return "cms/home";
    }
}
