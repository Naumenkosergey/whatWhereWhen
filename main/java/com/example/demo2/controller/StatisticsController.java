package com.example.demo2.controller;

import com.example.demo2.model.Znatok;
import com.example.demo2.service.ZnatokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StatisticsController {

    final
    ZnatokService znatokService;

    @Autowired
    public StatisticsController(ZnatokService znatokService) {
        this.znatokService = znatokService;
    }


    @GetMapping("/statistic")
    public String findAll(Model model) {
        List<Znatok> znatoks = znatokService.findAll();
        model.addAttribute( "znatoks", znatoks );
        return "statistics";
    }

//    @GetMapping("/znatok-create")
//    public String createZnatokForm(Znatok znatok) {
//        return "#";
//    }

//    @PostMapping
//    public String createZnatok(Znatok znatok) {
//        znatokService.saveZnatok( znatok );
//        return "redirect:/znatoks";
//    }
}
