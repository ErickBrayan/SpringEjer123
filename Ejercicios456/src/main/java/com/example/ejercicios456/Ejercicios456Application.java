package com.example.ejercicios456;

import com.example.ejercicios456.entity.Laptop;
import com.example.ejercicios456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Ejercicios456Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Ejercicios456Application.class, args);

        LaptopRepository repository = context.getBean(LaptopRepository.class);

        repository.save(new Laptop(null,"hp","45HJ","745896244523", LocalDate.of(2018,4,28),true));
        repository.save(new Laptop(null,"Asus","50HJ","835796244523", LocalDate.of(2019,5,15),false));


    }

}
