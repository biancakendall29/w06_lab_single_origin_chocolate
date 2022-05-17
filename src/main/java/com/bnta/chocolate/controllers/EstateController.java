package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("estates")
public class EstateController {

    @Autowired
    EstateRepository estateRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<Estate>> getEstates() {
        return new ResponseEntity<>(estateRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estate>> getEstate(@PathVariable Long id) {
        return new ResponseEntity(estateRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<Estate> createEstate(@RequestBody Estate newEstate) {
        estateRepository.save(newEstate);
        return new ResponseEntity(newEstate, HttpStatus.CREATED);
    }

}
