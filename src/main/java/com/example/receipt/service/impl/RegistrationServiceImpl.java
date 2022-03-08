package com.example.receipt.service.impl;


import com.example.receipt.appuser.AppUser;
import com.example.receipt.appuser.AppUserRole;
import com.example.receipt.appuser.RegistrationRequest;
import com.example.receipt.service.AppUserService;
import com.example.receipt.service.EmailValidator;
import com.example.receipt.service.RegistrationService;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@NoArgsConstructor

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    AppUserService appUserService;

    @Autowired
    EmailValidator emailValidator;

    @Override
    public String register (RegistrationRequest request) {
        boolean isValidEmail= emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        if (request.getPassword()==null){
            throw new IllegalStateException("please make password field is not empty");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

}
