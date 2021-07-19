package com.example.demo2.controller;

import com.example.demo2.util.AutorizationUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
//        model.addAttribute(  )
        if (AutorizationUser.isAutorization())
            return "index";
        else
            return "autorization";
    }
}
