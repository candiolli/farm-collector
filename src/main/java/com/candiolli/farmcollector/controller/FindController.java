package com.candiolli.farmcollector.controller;

import com.candiolli.farmcollector.repository.FarmRepository;
import com.candiolli.farmcollector.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {

    private FarmRepository farmRepository;
    private FieldRepository fieldRepository;

    @Autowired
    public FindController(FarmRepository farmRepository, FieldRepository fieldRepository) {
        this.farmRepository = farmRepository;
        this.fieldRepository = fieldRepository;
    }

    @GetMapping(value = "/farms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllFarms() {
        return ResponseEntity.ok(farmRepository.findAll());
    }

    @GetMapping(value = "/fields", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllFields() {
        return ResponseEntity.ok(fieldRepository.findAll());
    }
}
