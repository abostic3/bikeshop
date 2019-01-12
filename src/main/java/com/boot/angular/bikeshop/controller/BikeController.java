package com.boot.angular.bikeshop.controller;

import com.boot.angular.bikeshop.model.Bike;
import com.boot.angular.bikeshop.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> getAllBikes(){
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBike(@RequestBody Bike bike){
        bikeRepository.save(bike);
        System.out.println("Bike added");
        //insert into database
        //     repo.save(bike);

    }

    @GetMapping("/{id}")
    public Bike getBike(@PathVariable("id") Long id){
        return bikeRepository.getOne(id);
    }

}
