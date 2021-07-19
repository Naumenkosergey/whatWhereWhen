package com.example.demo2.controller;

import com.example.demo2.model.User;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {
    private final UserRepository userRepository;

    List<User> users = new ArrayList<>();

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "register";
    }

    @PostMapping("/signUp")
    public String addUser(@RequestParam String login,
                          @RequestParam String email,
                          @RequestParam String psw,
                          @RequestParam String psw_repeat,
                          Model model) {
        users = userRepository.findAll();

        if (!login.matches( "\\w{5,}" )) {
            model.addAttribute( "message", "некоректные данные по логину" );
            model.addAttribute( "page", "signUp" );
            return "error";
        } else if (!email.matches( "\\w{4,}@\\w{3,}\\.\\w{2,4}" )) {
            model.addAttribute( "message", "Невалидный e-mail" );
            model.addAttribute( "page", "signUp" );
            return "error";
        } else if (!psw.matches( "\\w{8,}" ) || !psw_repeat.matches( "\\w{8,}" )) {
            model.addAttribute( "message", "пароли не подходят" );
            model.addAttribute( "page", "signUp" );
            return "error";
        } else if (!checkPassw( psw, psw_repeat )) {
            model.addAttribute( "message", "пароли не совпадают" );
            model.addAttribute( "page", "signUp" );
            return "error";
        }

        if (uniqLogin( login ) && uniqEmail( email )) {
            User user = new User( login, email, psw, psw_repeat );
            userRepository.save( user );
            return "index";
        } else {
            model.addAttribute( "message", "логин или e-mail уже используется" );
            model.addAttribute( "page", "signUp" );
            return "errors";
        }
    }

    private boolean uniqEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals( email ))
                return false;
        }
        return true;
    }

    private boolean uniqLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals( login ))
                return false;
        }
        return true;
    }

    boolean checkPassw(String s1, String s2) {
        return s1.equals( s2 );
    }
}

