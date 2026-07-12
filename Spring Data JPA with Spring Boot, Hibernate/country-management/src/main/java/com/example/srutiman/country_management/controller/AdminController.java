package com.example.srutiman.country_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/info")
    public String adminInfo() {

        return "Welcome Admin!";

    }
}