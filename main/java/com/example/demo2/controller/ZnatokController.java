package com.example.demo2.controller;

import com.example.demo2.model.Znatok;
import com.example.demo2.repository.ZnatokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ZnatokController {

    final
    ZnatokRepository znatokRepository;

    @Autowired
    public ZnatokController(ZnatokRepository znatokRepository) {
        this.znatokRepository = znatokRepository;
    }

    @GetMapping("/znatoks")
    public String findAll( Model model){
        List<Znatok> znatoks = znatokRepository.findAll();
        model.addAttribute( znatoks );
        return "znatok-list";

    }
}
