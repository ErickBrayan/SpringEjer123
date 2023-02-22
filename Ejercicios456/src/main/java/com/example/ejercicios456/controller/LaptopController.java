package com.example.ejercicios456.controller;

import com.example.ejercicios456.entity.Laptop;
import com.example.ejercicios456.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @GetMapping("/api/laptop")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    @PostMapping("/api/laptop")
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }
}
