package com.example.receipt.service;


import com.example.receipt.appuser.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface AppUserService extends UserDetailsService {
    public String signUpUser(AppUser appUser);



}
