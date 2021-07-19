package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditTeamController {

    @GetMapping("/editteam")
    public String editTeam(){
        return "teamedit";
    }
}
