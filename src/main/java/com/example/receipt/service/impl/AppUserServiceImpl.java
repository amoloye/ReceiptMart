package com.example.receipt.service.impl;

import com.example.receipt.appuser.AppUser;
import com.example.receipt.repository.AppUserRepository;
import com.example.receipt.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final static String USER_NOT_FOUND_MSG= "user with email %s not found";

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;




    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }


    @Override
    public String signUpUser (AppUser appUser) {
        boolean userExists= appUserRepository.
                findByEmail(appUser.getUsername())
                .isPresent();

        if (userExists){
            throw  new IllegalStateException("email already taken");
        }

        //new addition
        if (appUser.getPassword()==null){
            throw new IllegalStateException("please input password");
        }
        String encodedPassword =bCryptPasswordEncoder.encode((appUser.getPassword()));

        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        //TODO: Send confirmation token


        return "";
    }
}
