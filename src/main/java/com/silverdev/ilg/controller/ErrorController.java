package com.silverdev.ilg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String erro(){
        return "redirect:/https://www.youtube.com/watch?v=3O-dkGmp_lg";
    }
}
