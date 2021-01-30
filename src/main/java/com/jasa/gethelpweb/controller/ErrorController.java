package com.jasa.gethelpweb.controller;

import com.jasa.gethelpweb.model.Petugas;
import com.jasa.gethelpweb.repository.PetugasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Autowired
    PetugasRepository petugasRepository;


    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        String errorPage = "error"; //default

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null){
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()){
                errorPage = "error/404";
            }
//            else if (statusCode == HttpStatus.FORBIDDEN.value()){
//                // 403 forbidden
//                errorPage = "error/403";
//            }else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
//                // 500 server error
//            }
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Petugas petugas = petugasRepository.findByEmail(userDetails.getUsername());
        model.addAttribute("user", petugas);

        return errorPage;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
