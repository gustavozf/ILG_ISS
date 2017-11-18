package com.silverdev.ilg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

    //https://www.youtube.com/watch?v=3O-dkGmp_lg

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping
    public String error(){
        return "Exta errado";
    }


}
