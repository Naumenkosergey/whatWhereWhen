package com.example.demo2.controller;



import com.example.demo2.model.User;
import com.example.demo2.service.UserServece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserServece userServece;

    @Autowired
    public UserController(UserServece userServece) {
        this.userServece = userServece;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userServece.findAll();
        model.addAttribute( "users",users );
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return"user-create";
    }

    @PostMapping
    public String createUser(User user){
       userServece.saveUser( user );
       return "redirect:/users";
    }


}
