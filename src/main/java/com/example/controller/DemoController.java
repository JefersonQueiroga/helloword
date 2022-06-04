package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoController {
    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping("/callback")
    public String getCallback() {
        return "homePage";
    }
}
