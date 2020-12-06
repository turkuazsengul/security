package com.okay.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OkaySecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(OkaySecurityApplication.class, args);
        System.out.println("Security application started!");
    }
}