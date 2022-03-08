package com.example.receipt.controller;



import com.example.receipt.appuser.RegistrationRequest;
import com.example.receipt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor

@RestController
@RequestMapping("/")
public class RegistrationController {

   private RegistrationService registrationService;

    @GetMapping("/home")
    public String homePage(){
        return "welcome to the home page, click login/register to continue";
    }

    @GetMapping("/register")
    public String getRegistrationForm(){
        return "register";

    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login_page";
    }



}
