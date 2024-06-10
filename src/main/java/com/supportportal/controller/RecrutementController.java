package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Recrutement;
import com.supportportal.service.RecrutementService;


@RestController
@RequestMapping("/recruitments")
public class RecrutementController {

    @Autowired
    private RecrutementService recrutementService;

    @PostMapping("/add")
    public ResponseEntity<Recrutement> createRecrutement(@Validated @RequestBody Recrutement recrutement) {
        Recrutement savedRecrutement = recrutementService.saveRecrutement(recrutement);
        return new ResponseEntity<>(savedRecrutement, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Recrutement>> getAllRecruitments() {
        List<Recrutement> recruitments = recrutementService.findAllRecruitments();
        return new ResponseEntity<>(recruitments, HttpStatus.OK);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Recrutement> getRecrutementById(@PathVariable Long id) {
        Recrutement recrutement = recrutementService.findByIdRecrutement(id);
        if (recrutement != null) {
            return new ResponseEntity<>(recrutement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recrutement> updateRecrutement(@PathVariable Long id, @Validated
    		@RequestBody Recrutement recrutement) {
        if (!id.equals(recrutement.getIdRecrutement())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // IDs don't match
        }

        Recrutement updatedRecrutement = recrutementService.updateRecrutement(recrutement);
        if (updatedRecrutement != null) {
            return new ResponseEntity<>(updatedRecrutement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRecrutement(@PathVariable Long id) {
        recrutementService.deleteRecrutement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}