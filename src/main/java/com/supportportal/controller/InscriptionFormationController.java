package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.supportportal.entity.InscriptionFormation;
import com.supportportal.service.InscriptionFormationService;




@RestController
@RequestMapping("/inscriptionformations")
public class InscriptionFormationController {

    @Autowired
    private InscriptionFormationService inscriptionFormationService;

    @PostMapping
    public ResponseEntity<InscriptionFormation> createInscriptionFormation(@Validated @RequestBody InscriptionFormation inscriptionFormation) {
        InscriptionFormation savedInscriptionFormation = inscriptionFormationService.saveInscriptionFormation(inscriptionFormation);
        return new ResponseEntity<>(savedInscriptionFormation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InscriptionFormation>> getAllInscriptionFormations() {
        List<InscriptionFormation> inscriptionFormations = inscriptionFormationService.findAllInscriptionFormations();
        return new ResponseEntity<>(inscriptionFormations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionFormation> getInscriptionFormationById(@PathVariable Long id) {
        InscriptionFormation inscriptionFormation = inscriptionFormationService.findByIdInscription(id);
        if (inscriptionFormation != null) {
            return new ResponseEntity<>(inscriptionFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscriptionFormation> updateInscriptionFormation(@PathVariable Long id, @Validated @RequestBody InscriptionFormation inscriptionFormation) {
        if (!id.equals(inscriptionFormation.getIdInscription())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // IDs don't match
        }

        InscriptionFormation updatedInscriptionFormation = inscriptionFormationService.updateInscriptionFormation(inscriptionFormation);
        if (updatedInscriptionFormation != null) {
            return new ResponseEntity<>(updatedInscriptionFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscriptionFormation(@PathVariable Long id) {
        inscriptionFormationService.deleteInscriptionFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}