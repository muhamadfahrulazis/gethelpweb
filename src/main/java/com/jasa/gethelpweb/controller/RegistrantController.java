package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.Registrant;
import com.jasa.gethelpweb.repository.RegistrantRepository;
import com.jasa.gethelpweb.service.RegistrantService;
import com.jasa.gethelpweb.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Controller
public class RegistrantController {

    @Autowired
    RegistrantService registrantService;

    @GetMapping("/registrationForm")
    public String showRegistrationForm(Model model){
        Registrant registrant = new Registrant();
        model.addAttribute("registrant", registrant);
        return "registration";
    }

    @PostMapping("/register")
    public String registrationAccount(@RequestParam("photoKtp") MultipartFile multipartFilePhotoKtp,
                                      @RequestParam("selfieKtp") MultipartFile multipartFileSelfieKtp,
                                      @ModelAttribute("registrant") Registrant registrant) throws IOException {

        String fileNameKtp = StringUtils.cleanPath(multipartFilePhotoKtp.getOriginalFilename());
        String fileNameSelfieKtp = StringUtils.cleanPath(multipartFileSelfieKtp.getOriginalFilename());

        String status = "success";
        try {
            registrant.setUrlPhotoKtp(fileNameKtp);
            registrant.setUrlSelfieKtp(fileNameSelfieKtp);

            Registrant savedRegistrant = registrantService.saveRegistrant(registrant);

            String uploadDirKtp = "file_registrant/ktp/" + savedRegistrant.getId();
            String uploadDirSelfieKtp = "file_registrant/selfie_ktp/" + savedRegistrant.getId();

            FileUploadUtil.saveFile(uploadDirKtp, fileNameKtp, multipartFilePhotoKtp);
            FileUploadUtil.saveFile(uploadDirSelfieKtp, fileNameSelfieKtp, multipartFileSelfieKtp);
        }catch (Exception e){
            status = "failed";
        }

        return "redirect:/registrationForm?" + status;
    }

    @GetMapping("/cms/list_registrant")
    public String viewServiceProvider(Model model){
        model.addAttribute("listRegistrant", registrantService.getAllRegistrant());
        model.addAttribute("registrant", new Registrant());
        return "cms/list_registrant";
    }

    @GetMapping("/showRegistrantById")
    @ResponseBody
    public Registrant showRegistrantById(long id){
        return registrantService.getRegistrantById(id);
    }

    @PostMapping("/updateRegistrant")
    public String updateRegistrant(@RequestParam("photoKtp") MultipartFile multipartFilePhotoKtp,
                                      @RequestParam("selfieKtp") MultipartFile multipartFileSelfieKtp,
                                      @ModelAttribute("registrant") Registrant registrant) throws IOException {

        String fileNameKtp = StringUtils.cleanPath(multipartFilePhotoKtp.getOriginalFilename());
        String fileNameSelfieKtp = StringUtils.cleanPath(multipartFileSelfieKtp.getOriginalFilename());

        registrant.setUrlPhotoKtp(fileNameKtp);
        registrant.setUrlSelfieKtp(fileNameSelfieKtp);

        Registrant savedRegistrant = registrantService.saveRegistrant(registrant);

        String uploadDirKtp = "file_registrant/ktp/" + savedRegistrant.getId();
        String uploadDirSelfieKtp = "file_registrant/selfie_ktp/" + savedRegistrant.getId();

        FileUploadUtil.saveFile(uploadDirKtp, fileNameKtp, multipartFilePhotoKtp);
        FileUploadUtil.saveFile(uploadDirSelfieKtp, fileNameSelfieKtp, multipartFileSelfieKtp);

        return "redirect:/cms/list_registrant";
    }

    @GetMapping("/deleteRegistrantById/{id}")
    public String deleteRegistrantById(@PathVariable(value = "id") long id){
        Registrant registrant = registrantService.getRegistrantById(id);
        // File or Directory to be deleted
        Path pathKtp = Paths.get(registrant.getUrlPhotoKtp());
        Path pathSelfieKtp = Paths.get(registrant.getUrlSelfieKtp());

        Path pathFolderKtp = Paths.get("file_registrant/ktp/" + registrant.getId());
        Path pathFolderSelfieKtp = Paths.get("file_registrant/selfie_ktp/" + registrant.getId());

        try {
            // Delete file or directory
            Files.delete(pathKtp);
            Files.delete(pathSelfieKtp);
            Files.delete(pathFolderKtp);
            Files.delete(pathFolderSelfieKtp);
            System.out.println("File or directory deleted successfully");
        } catch (NoSuchFileException ex) {
            System.out.printf("No such file or directory: %s\n", pathKtp);
            System.out.printf("No such file or directory: %s\n", pathSelfieKtp);
        } catch (DirectoryNotEmptyException ex) {
            System.out.printf("Directory %s is not empty\n", pathKtp);
            System.out.printf("Directory %s is not empty\n", pathSelfieKtp);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        registrantService.deleteRegistrantById(id);
        return "redirect:/cms/list_registrant";
    }
}
