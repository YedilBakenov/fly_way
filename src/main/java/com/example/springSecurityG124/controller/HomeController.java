package com.example.springSecurityG124.controller;

import com.example.springSecurityG124.model.User;
import com.example.springSecurityG124.repository.UserRepository;
import com.example.springSecurityG124.service.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ServiceUser serviceUser;
    private final UserRepository userRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/")
    public String mainPage(){
        System.out.println(serviceUser.getCurrentUser().getEmail());
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in")
    public String signIn(){
        return "sign-in";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping(value = "/forbidden")
    public String forbidden(){
        return "forbidden";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(value = "/register")
    public String register(User user, @RequestParam String rePassword){
        String result =  serviceUser.addUser(user, rePassword);
        return "redirect:/sign-in?" + result;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/change-password")
    public String changePass(@RequestParam String currentPass,
                             @RequestParam String newPass,
                             @RequestParam String reNewPass){

        String result =  serviceUser.changePass(currentPass, newPass, reNewPass);
        return "redirect:/" + result;

    }
}

