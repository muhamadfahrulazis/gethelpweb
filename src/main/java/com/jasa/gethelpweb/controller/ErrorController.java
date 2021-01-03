package com.jasa.gethelpweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        String errorPage = "error"; //default

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null){
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()){
                errorPage = "error/404";
            }else if (statusCode == HttpStatus.FORBIDDEN.value()){
                // 403 forbidden
            }else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                // 500 server error
            }
        }

        return errorPage;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
