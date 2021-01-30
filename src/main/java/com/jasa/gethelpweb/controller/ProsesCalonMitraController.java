package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Keahlian;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.service.CalonMitraService;
import com.jasa.gethelpweb.service.KeahlianCalonMitraService;
import com.jasa.gethelpweb.service.KeahlianService;
import com.jasa.gethelpweb.service.ProsesCalonMitraService;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

@Controller
public class ProsesCalonMitraController {

    @Autowired
    CalonMitraService calonMitraService;

    @Autowired
    ProsesCalonMitraService prosesCalonMitraService;

    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    KeahlianCalonMitraService keahlianCalonMitraService;

    @Autowired
    KeahlianService keahlianService;

    @GetMapping("/cms/list_verifikasi")
    public String viewVerifikasi(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);
        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        model.addAttribute("listVerifikasi", calonMitraService.getAllVerifikasi());
        model.addAttribute("calonmitra", new CalonMitra());
        model.addAttribute("prosesCalonmitra", new ProsesCalonMitra());
        return "cms/list_verifikasi";
    }

    @PostMapping("/verifikasiCalonMitra")
    public String verifikasiCalonMitra(@ModelAttribute("calonmitra") CalonMitra calonMitra,
                                       @ModelAttribute("prosesCalonmitra") ProsesCalonMitra prosesCalonMitra) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );
        String status = "success";
        try {
            prosesCalonMitraService.verifikasiCalonMitra(prosesCalonMitra.getAlasanGagal(),
                    0, 0, petugas.getNip(),
                    null, null, new Date(),
                    calonMitra.getId_calonmitra(), prosesCalonMitra.getKode_proses());

            calonMitraService.updateVerifikasi(calonMitra.getId_calonmitra());
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/cms/list_verifikasi?" + status;
    }

    @GetMapping("/cms/list_training")
    public String viewTraining(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );
        model.addAttribute("user", petugas);
        model.addAttribute("listTraining", prosesCalonMitraService.getAllTrainingCalonMitra());
        model.addAttribute("listKeahlian", keahlianService.getAllKeahlian());
        model.addAttribute("calonmitra", new CalonMitra());
        model.addAttribute("keahlian", new Keahlian());
        model.addAttribute("prosesCalonmitra", new ProsesCalonMitra());
        return "cms/list_training";
    }

    @PostMapping("/trainingCalonMitra")
    public String trainingCalonMitra(@ModelAttribute("calonmitra") CalonMitra calonMitra,
                                     @ModelAttribute("prosesCalonmitra") ProsesCalonMitra prosesCalonMitra,
                                     @ModelAttribute("keahlian") Keahlian keahlian) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );

        String status = "success";
        try {
            prosesCalonMitraService.trainingCalonMitra(prosesCalonMitra.getAlasanGagal(),
                    petugas.getNip(), new Date(), prosesCalonMitra.getKode_proses(),
                    calonMitra.getId_calonmitra());

            if (prosesCalonMitra.getKode_proses().equals("12")){
                keahlianCalonMitraService.keahlianCalonMitra(calonMitra.getId_calonmitra(), keahlian.getId_keahlian());
            }
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/cms/list_training?" + status;
    }

    @GetMapping("/cms/list_onboarding")
    public String viewMitraOnboarding(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );
        model.addAttribute("user", petugas);
        model.addAttribute("listOnboarding", prosesCalonMitraService.getAllOnboardingCalonMitra());
        model.addAttribute("listKeahlian", keahlianService.getAllKeahlian());
        model.addAttribute("calonmitra", new CalonMitra());
        model.addAttribute("prosesCalonmitra", new ProsesCalonMitra());
        return "cms/list_onboarding";
    }

    @PostMapping("/onboardingCalonMitra")
    public String onboardingCalonMitra(@ModelAttribute("calonmitra") CalonMitra calonMitra,
                                       @ModelAttribute("prosesCalonmitra") ProsesCalonMitra prosesCalonMitra) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );

        String status = "success";
        try {
            prosesCalonMitraService.onboardingCalonMitra(prosesCalonMitra.getAlasanGagal(),
                    petugas.getNip(), new Date(), prosesCalonMitra.getKode_proses(),
                    calonMitra.getId_calonmitra());
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/cms/list_onboarding?" + status;
    }

    @GetMapping("/cms/list_gagal")
    public String viewServiceProvider(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );
        model.addAttribute("user", petugas);
        model.addAttribute("listGagal", prosesCalonMitraService.getAllGagalCalonMitra());
        model.addAttribute("calonmitra", new CalonMitra());
        model.addAttribute("prosesCalonmitra", new ProsesCalonMitra());
        return "cms/list_gagal";
    }

    @GetMapping("/showMitraGagalById")
    @ResponseBody
    public ProsesCalonMitra showMitraGagalById(long id){
        return prosesCalonMitraService.getMitraGagalById(id);
    }

    @GetMapping("/cms/list_mitra_aktif")
    public String viewMitraAktif(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = EnkripsiDekripsiUtil.dekripsiPetugas(
                petugasRepository.findByEmail(eEmail)
        );
        model.addAttribute("user", petugas);
        model.addAttribute("listMitraAktif", prosesCalonMitraService.getAllMitraAktif());
        model.addAttribute("listKeahlian", keahlianService.getAllKeahlian());
        model.addAttribute("calonmitra", new CalonMitra());
        model.addAttribute("prosesCalonmitra", new ProsesCalonMitra());
        return "cms/list_mitra_aktif";
    }

    @GetMapping("/showMitraAktifById")
    @ResponseBody
    public ProsesCalonMitra showMitraAktifById(long id){
        return prosesCalonMitraService.getMitraAktifById(id);
    }

}
