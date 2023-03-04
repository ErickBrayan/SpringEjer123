package com.example.ejercicios456.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello/ola")
    public String greeting(){
        return "Hello World!!!";
    }
}
