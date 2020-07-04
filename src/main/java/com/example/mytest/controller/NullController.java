package com.example.mytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NullController {
    @GetMapping("/")
    public String defaultNull(){
        return "default/index";
    }
}
