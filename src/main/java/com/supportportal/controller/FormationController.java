package com.supportportal.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supportportal.domain.HttpResponse;
import com.supportportal.entity.Formation;
import com.supportportal.entity.Planning;
import com.supportportal.service.FormationService;



@RestController
@RequestMapping("/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

   
    @GetMapping("/list")
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.findAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }




    @PostMapping("/update")
    public ResponseEntity<Formation> updateFormation(
            @RequestParam("idFormation") Long idFormation,
            @RequestParam("module") String module,
            @RequestParam("type") String type,
            @RequestParam("categorie") String categorie,
            @RequestParam("description") String description,
            @RequestParam("proposePar") String proposePar,
            @RequestParam("posteProposerPar") String posteProposerPar,
            @RequestParam(value = "cabinetproposer", required = false) String cabinetproposer,
            @RequestParam("departement") String departement,
            @RequestParam("objectif") String objectif,
            @RequestParam("activite") String activite,
            @RequestParam(value = "formateurPropose", required = false) String formateurPropose,
            @RequestParam(value = "observation", required = false) String observation,
            @RequestParam("budgetPrevisionnel") String budgetPrevisionnel) {

        Formation updatedFormation = formationService.updateFormation(
                idFormation, module, type, categorie, description, proposePar, posteProposerPar,
                cabinetproposer, departement, objectif, activite, formateurPropose, observation, budgetPrevisionnel);
        
        if (updatedFormation != null) {
            return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/addFormationToPlanning")
    public ResponseEntity<Planning> addFormationToPlanning(@RequestParam("idFormation") Long idFormation) {
        try {
            Planning newPlanning = formationService.addFormationToPlanning(idFormation);
            return new ResponseEntity<>(newPlanning, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    


    @PostMapping("/assignEmployeesToFormation")
    public ResponseEntity<HttpResponse> assignEmployeesToFormation(@RequestParam("formationId") Long formationId,
                                                                   @RequestParam("employeeNames") List<String> employeeNames) {
        
            formationService.affecterEmployeesToFormation(formationId, employeeNames);
            return response(HttpStatus.OK, "Les employés ont été assignés à la formation avec succès");
    }
    
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        HttpResponse body = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase());
        return new ResponseEntity<>(body, httpStatus);
    }
    
    
    @DeleteMapping("/delete/{idFormation}")
    public ResponseEntity<HttpResponse> deleteFormation(@PathVariable("idFormation") Long idFormation) {
        formationService.deleteFormation(idFormation);
        return response(HttpStatus.OK, "Formation a été supprimée avec succès");
    }
}