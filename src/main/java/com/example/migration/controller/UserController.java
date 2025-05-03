package com.example.migration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class UserController {

    @GetMapping("/profile")
    public String getProfile(@RequestHeader("X-USER") String username) {
        System.out.println("Migrated one user from SQL to MongoDB successfully!");
        return "";
    }
}
