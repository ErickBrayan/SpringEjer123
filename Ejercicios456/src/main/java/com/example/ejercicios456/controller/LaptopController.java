package com.example.ejercicios456.controller;

import com.example.ejercicios456.entity.Laptop;
import com.example.ejercicios456.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneByID(@PathVariable Long id){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()){
            return ResponseEntity.ok(optionalLaptop.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        Laptop laptop1 = laptopRepository.save(laptop);
        if (laptop1.getName().isEmpty())return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(laptop1);
    }
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        if (laptop.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        if(laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.ok(laptopRepository.save(laptop));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
