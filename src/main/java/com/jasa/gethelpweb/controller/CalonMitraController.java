package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.CalonMitra;
import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.model.ProsesCalonMitra;
import com.jasa.gethelpweb.repository.CalonMitraRepository;
import com.jasa.gethelpweb.repository.KeahlianCalonMitraRepository;
import com.jasa.gethelpweb.repository.PetugasRepository;
import com.jasa.gethelpweb.repository.ProsesCalonMitraRepository;
import com.jasa.gethelpweb.service.CalonMitraService;
import com.jasa.gethelpweb.utils.AES256;
import com.jasa.gethelpweb.utils.EnkripsiDekripsiUtil;
import com.jasa.gethelpweb.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

@Controller
public class CalonMitraController {

    @Autowired
    CalonMitraService calonMitraService;

    @Autowired
    PetugasRepository petugasRepository;

    @Autowired
    ProsesCalonMitraRepository prosesCalonMitraRepository;

    @Autowired
    KeahlianCalonMitraRepository keahlianCalonMitraRepository;

    @GetMapping("/registrationForm")
    public String showRegistrationForm(Model model){
        CalonMitra calonMitra = new CalonMitra();
        model.addAttribute("calonmitra", calonMitra);
        return "registration";
    }

    @PostMapping("/register")
    public String registrationAccount(@RequestParam("photoKtp") MultipartFile multipartFilePhotoKtp,
                                      @RequestParam("selfieKtp") MultipartFile multipartFileSelfieKtp,
                                      @ModelAttribute("calonmitra") CalonMitra calonMitra) {

        String fileNameKtp = StringUtils.cleanPath(Objects.requireNonNull(multipartFilePhotoKtp.getOriginalFilename()));
        String fileNameSelfieKtp = StringUtils.cleanPath(Objects.requireNonNull(multipartFileSelfieKtp.getOriginalFilename()));

        String status = "success";
        try {
            calonMitra.setNamaFileKtpCalonMitra(fileNameKtp);
            calonMitra.setNamaFileSelfiektpCalonMitra(fileNameSelfieKtp);
            calonMitra.setIsNewRegistrant("1");

            CalonMitra savedCalonMitra = calonMitraService.saveCalonMitra(calonMitra);

            String uploadDirKtp = "file_registrant/ktp/" + savedCalonMitra.getId_calonmitra();
            String uploadDirSelfieKtp = "file_registrant/selfie_ktp/" + savedCalonMitra.getId_calonmitra();

            FileUploadUtil.saveFile(uploadDirKtp, fileNameKtp, multipartFilePhotoKtp);
            FileUploadUtil.saveFile(uploadDirSelfieKtp, fileNameSelfieKtp, multipartFileSelfieKtp);
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/registrationForm?" + status;
    }

    @PostMapping("/updateCalonMitra")
    public String updateCalonMitra(@RequestParam("photoKtp") MultipartFile multipartFilePhotoKtp,
                                   @RequestParam("selfieKtp") MultipartFile multipartFileSelfieKtp,
                                   @ModelAttribute("calonmitra") CalonMitra calonMitra) throws IOException {

        if (!multipartFilePhotoKtp.isEmpty()){
            String fileNameKtp = StringUtils.cleanPath(Objects.requireNonNull(multipartFilePhotoKtp.getOriginalFilename()));
            String uploadDirKtp = "file_registrant/ktp/" + calonMitra.getId_calonmitra();
            deletePhotoKtp(calonMitra);
            calonMitra.setNamaFileKtpCalonMitra(fileNameKtp);
            FileUploadUtil.saveFile(uploadDirKtp, fileNameKtp, multipartFilePhotoKtp);
        }

        if (!multipartFileSelfieKtp.isEmpty()){
            String fileNameSelfieKtp = StringUtils.cleanPath(Objects.requireNonNull(multipartFileSelfieKtp.getOriginalFilename()));
            String uploadDirSelfieKtp = "file_registrant/selfie_ktp/" + calonMitra.getId_calonmitra();
            deleteSelfieKtp(calonMitra);
            calonMitra.setNamaFileSelfiektpCalonMitra(fileNameSelfieKtp);
            FileUploadUtil.saveFile(uploadDirSelfieKtp, fileNameSelfieKtp, multipartFileSelfieKtp);
        }

        System.out.printf("Directory %s", calonMitra.getNamaFileKtpCalonMitra());

        String status = "success";
        try {
            calonMitraService.saveCalonMitra(calonMitra);
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/cms/list_calonmitra?" + status;
    }

    @GetMapping("/cms/list_calonmitra")
    public String listCalonMitra(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String eEmail = AES256.encrypt(userDetails.getUsername());
        Petugas petugas = petugasRepository.findByEmail(eEmail);
        model.addAttribute("user", EnkripsiDekripsiUtil.dekripsiPetugas(petugas));
        model.addAttribute("listCalonMitra", calonMitraService.getAllCalonMitra());
        model.addAttribute("calonmitra", new CalonMitra());
        return "cms/list_calonmitra";
    }

    @GetMapping("/showCalonMitraById")
    @ResponseBody
    public CalonMitra showCalonMitraById(long id){
        return calonMitraService.getCalonMitraById(id);
    }

    @GetMapping("/deleteCalonMitraById")
    public String deleteCalonMitraById(@RequestParam("id_calonmitra") long id){
        String status = "successDelete";
        try {
            CalonMitra calonMitra = calonMitraService.getCalonMitraById(id);

            deletePhotoKtp(calonMitra);
            deleteSelfieKtp(calonMitra);

            keahlianCalonMitraRepository.deleteKeahlianCalonMitra(id);
            prosesCalonMitraRepository.deleteProsesCalonMitra(id);
            calonMitraService.deleteCalonMitraById(id);
        }catch (Exception e){
            status = "failedDelete";
        }

        return "redirect:/cms/list_calonmitra?" + status;
    }

    private void deletePhotoKtp(CalonMitra calonMitra){
        // File or Directory to be deleted
        Path pathKtp = Paths.get(calonMitra.getNamaFileKtpCalonMitra());

        Path pathFolderKtp = Paths.get("file_registrant/ktp/" + calonMitra.getId_calonmitra());

        try {
            // Delete file or directory
            Files.delete(pathKtp);
            Files.delete(pathFolderKtp);
            System.out.println("File or directory deleted successfully");
        } catch (NoSuchFileException ex) {
            System.out.printf("No such file or directory: %s\n", pathKtp);
        } catch (DirectoryNotEmptyException ex) {
            System.out.printf("Directory %s is not empty\n", pathKtp);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void deleteSelfieKtp(CalonMitra calonMitra){
        // File or Directory to be deleted
        Path pathSelfieKtp = Paths.get(calonMitra.getNamaFileSelfiektpCalonMitra());

        Path pathFolderSelfieKtp = Paths.get("file_registrant/selfie_ktp/" + calonMitra.getId_calonmitra());

        try {
            // Delete file or directory
            Files.delete(pathSelfieKtp);
            Files.delete(pathFolderSelfieKtp);
            System.out.println("File or directory deleted successfully");
        } catch (NoSuchFileException ex) {
            System.out.printf("No such file or directory: %s\n", pathSelfieKtp);
        } catch (DirectoryNotEmptyException ex) {
            System.out.printf("Directory %s is not empty\n", pathSelfieKtp);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
