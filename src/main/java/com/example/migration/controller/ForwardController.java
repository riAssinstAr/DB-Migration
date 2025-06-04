package com.example.migration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    @GetMapping("/dashboard/sql")
    public String forwardSqlDashboard() {
        return "forward:/index.html";
    }

    @GetMapping("/dashboard/mongo")
    public String forwardMongoDashboard() {
        return "forward:/index.html";
    }

    @GetMapping("/")
    public String forwardHome() {
        return "forward:/index.html";
    }
}
