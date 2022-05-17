package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<Chocolate>> getChocolatesAndFilters(
            @RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage) {
        if (cocoaPercentage != null) {
            return new ResponseEntity(chocolateRepository.findChocolateByCocoaPercentage(cocoaPercentage), HttpStatus.OK);
        }
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id) {
        return new ResponseEntity(chocolateRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate newChocolate) {
        chocolateRepository.save(newChocolate);
        return new ResponseEntity(newChocolate, HttpStatus.CREATED);
    }

}
