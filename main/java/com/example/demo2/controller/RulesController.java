package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RulesController {

    @GetMapping("/rules")
    public String rules(){
        return "rules";
    }
}
