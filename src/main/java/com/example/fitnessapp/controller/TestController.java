package com.example.fitnessapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/api/user/test")
    public String isUser() {
        return  "simple_user_accepted";
    }
    @GetMapping("/api/admin/test")
    public String isAdmin() {
        return  "admin_accepted";
    }
}
