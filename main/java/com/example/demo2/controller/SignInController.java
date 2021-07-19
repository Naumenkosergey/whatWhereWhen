package com.example.demo2.controller;

import com.example.demo2.model.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.util.AutorizationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignInController {
    private final UserRepository userRepository;

    List<User> users = new ArrayList<>();
    int indexUser;

    @Autowired
    public SignInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signIn")
    public String SignIn() {

        return "autorization";
    }

    @PostMapping("/signIn")
    public String login(@RequestParam String login,
                        @RequestParam String psw, Model model) {
        users = userRepository.findAll();
        if (!checkLogin( login )) {
            model.addAttribute( "message", "пользователя с логином " + login + " нет" );
            model.addAttribute( "page", "signIn" );
            return "error";
        } else {
            if (!checkPassword( psw )) {
                model.addAttribute( "message", "не верный пароль" );
                model.addAttribute( "page", "signIn" );
                return "error";
            }
        }
        AutorizationUser.autorizationUser = login;
        model.addAttribute( "autorizationuser", AutorizationUser.autorizationUser );
        return "index";
    }

    private boolean checkPassword(String password) {

        return password.equals( users.get( indexUser ).getPassw() );
    }

    private boolean checkLogin(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get( i ).getLogin().equals( login )) {
                indexUser = i;
                return true;
            }
        }
        return false;
    }
}
