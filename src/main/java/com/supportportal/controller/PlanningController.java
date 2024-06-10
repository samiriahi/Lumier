package com.supportportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supportportal.domain.HttpResponse;
import com.supportportal.entity.Planning;
import com.supportportal.service.PlanningService;

import static org.springframework.http.HttpStatus.OK;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @GetMapping("/list")
    public ResponseEntity<List<Planning>> getAllPlannings() {
        List<Planning> plannings = planningService.findAllPlannings();
        return new ResponseEntity<>(plannings, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Planning> getPlanningById(@PathVariable("id") Long id) {
        Planning planning = planningService.findByIdPlanning(id);
        return new ResponseEntity<>(planning, HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<Planning> updatePlanning(@RequestParam("idPlanning") Long idPlanning,
                                                   @RequestParam("module") String module,
                                                   @RequestParam("departement") String departement,
                                                   @RequestParam("type") String type,
                                                   @RequestParam("categorie") String categorie,
                                                   @RequestParam("demandeur") String demandeur,
                                                   @RequestParam("posteProposerPar") String posteProposerPar,
                                                   @RequestParam("cabinetproposer") String cabinetproposer,
                                                   @RequestParam("objectif") String objectif,
                                                   @RequestParam("activite") String activite,
                                                   @RequestParam("formateur") String formateur,
                                                   @RequestParam("observation") String observation,
                                                   @RequestParam("budgetPrevisionnel") String budgetPrevisionnel,
                                                   @RequestParam("budgetEstimatif") String budgetEstimatif,
                                                   @RequestParam("statusPlanning") String statusPlanning,
                                                   @RequestParam("coutreel") String coutreel,
                                                   @RequestParam("evaluationChaud") String evaluationChaud,
                                                   @RequestParam("evaluationFroid") String evaluationFroid,
                                                   @RequestParam("dateRealisation") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateRealisation) {
        Planning updatedPlanning = planningService.updatePlanning(idPlanning, module, departement, type, categorie,
                                                                  demandeur, posteProposerPar, cabinetproposer, objectif,
                                                                  activite, formateur, observation, budgetPrevisionnel,
                                                                  budgetEstimatif, statusPlanning, coutreel,
                                                                  evaluationChaud, evaluationFroid, dateRealisation);
        return new ResponseEntity<>(updatedPlanning, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPlanning}")
    public ResponseEntity<HttpResponse> deletePlanning(@PathVariable("idPlanning") Long idPlanning) {
        planningService.deletePlanning(idPlanning);
        return response( OK , "Planning  a ete supprimer avec success ") ; 
    }
    
    private  ResponseEntity<HttpResponse> response (HttpStatus httpStatus , String message ){
		HttpResponse body = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase()	,message.toUpperCase() )  ;
		return new  ResponseEntity<>( body , httpStatus ) ;
	}
    
}
