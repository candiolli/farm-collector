package com.candiolli.farmcollector.controller;

import com.candiolli.farmcollector.dto.HarvestedRequestDto;
import com.candiolli.farmcollector.dto.PlantedRequestDto;
import com.candiolli.farmcollector.model.Field;
import com.candiolli.farmcollector.model.Harvested;
import com.candiolli.farmcollector.model.Planted;
import com.candiolli.farmcollector.repository.FieldRepository;
import com.candiolli.farmcollector.repository.HarvestedRepository;
import com.candiolli.farmcollector.repository.PlantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/collect")
public class CollectController {

    private PlantedRepository plantedRepository;
    private HarvestedRepository harvestedRepository;
    private FieldRepository fieldRepository;

    @Autowired
    public CollectController(PlantedRepository plantedRepository,
                             HarvestedRepository harvestedRepository,
                             FieldRepository fieldRepository) {
        this.plantedRepository = plantedRepository;
        this.harvestedRepository = harvestedRepository;
        this.fieldRepository = fieldRepository;
    }

    @GetMapping(value = "/farms/{farmId}/fields/{fieldId}/planted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findPlanted(@PathVariable("farmId") Long farmId,
                                      @PathVariable("fieldId") Long fieldId) {
        List<Planted> byFieldFarmIdAndFieldId = plantedRepository.findByFieldFarmIdAndFieldId(farmId, fieldId);
        return ResponseEntity.ok(byFieldFarmIdAndFieldId);
    }

    @PostMapping(value = "/farms/{farmId}/fields/{fieldId}/planted",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePlanted(@PathVariable("farmId") Long farmId,
                                      @PathVariable("fieldId") Long fieldId,
                                      @RequestBody PlantedRequestDto body) {
        Planted entity = body.toEntity();

        Optional<Field> field = fieldRepository.findById(fieldId);
        if (field.isEmpty()) {
            return  ResponseEntity.badRequest().body("Field not found.");
        }

        entity.setField(field.get());
        plantedRepository.save(entity);
        return ResponseEntity.ok("Planted data successfully recorded");
    }

    @PostMapping("/farms/{farmId}/fields/{fieldId}/harvested")
    public ResponseEntity saveHarvested(@PathVariable("farmId") Long farmId,
                                        @PathVariable("fieldId") Long fieldId,
                                        @RequestBody HarvestedRequestDto body) {

        Harvested entity = body.toEntity();

        Optional<Field> field = fieldRepository.findById(fieldId);
        if (field.isEmpty()) {
            return ResponseEntity.badRequest().body("Field not found.");
        }

        entity.setField(field.get());
        harvestedRepository.save(entity);
        return ResponseEntity.ok("Harvested data successfully recorded");
    }
}
