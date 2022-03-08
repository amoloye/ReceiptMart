package com.example.receipt;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ReceiptApplication {

    public static void main (String[] args) {
        SpringApplication.run(ReceiptApplication.class, args);
    }

}
