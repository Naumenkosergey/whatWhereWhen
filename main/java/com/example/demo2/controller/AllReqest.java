package com.example.demo2.controller;

import com.example.demo2.util.AutorizationUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllReqest {

    @GetMapping("/*")
    public void getLogin(Model model){
        if(AutorizationUser.autorizationUser!=null);
            model.addAttribute( "autorizationuser", AutorizationUser.autorizationUser );




    }
}
