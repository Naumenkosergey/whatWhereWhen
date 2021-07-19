package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZnatokTeamController {

    @GetMapping("/teamznatoks")
    public String getTeamZnatoks(){
        return "znatokteam-list";
    }
}
