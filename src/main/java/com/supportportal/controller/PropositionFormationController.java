package com.supportportal.controller;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.HttpResponse;
import com.supportportal.entity.PropositionFormation;
import com.supportportal.service.PropositionFormationService;


@RestController
@RequestMapping("/propositionsformations")
public class PropositionFormationController {

    @Autowired
    private PropositionFormationService propositionFormationService;
    
    
    @Autowired
	public PropositionFormationController(PropositionFormationService propositionFormationService) {
		  this.propositionFormationService =  propositionFormationService ;
	}
    
    
    @GetMapping("/list")
   	public  ResponseEntity<List<PropositionFormation>> getAllPropositionFormations () {
   		List <PropositionFormation> propositionsFormation = propositionFormationService.getAllPropositionFormations();
   		return new  ResponseEntity<>(propositionsFormation, OK);
   	}    
    
    @PostMapping("/add")
    public ResponseEntity<PropositionFormation> addNewPropositionFormation(
            @RequestParam("module") String module,
            @RequestParam("type") String type,
            @RequestParam("categorie") String categorie,
            @RequestParam("description") String description,
            @RequestParam("proposePar") String proposePar,
            @RequestParam("posteProposerPar") String posteProposerPar,
            @RequestParam(value = "cabinetpropo", required = false) String cabinetpropo,
            @RequestParam("departement") String departement,
            @RequestParam("objectif") String objectif,
            @RequestParam("activite") String activite,
            @RequestParam(value = "observation", required = false) String observation,
            @RequestParam(value = "formateurPropose", required = false) String formateurPropose,
            @RequestParam("prdSouhaite") @DateTimeFormat(pattern = "yyyy-MM-dd") Date prdSouhaite,
            @RequestParam("employeeNames") List<String> employeeNames) {

        PropositionFormation newPropositionFormation = propositionFormationService.ajouterPropositionFormation(
                module, type, categorie, description, proposePar, posteProposerPar, cabinetpropo, departement,
                objectif, activite, observation, formateurPropose, prdSouhaite, employeeNames);
        
        return new ResponseEntity<>(newPropositionFormation, HttpStatus.CREATED);
    }

    
    
    @PostMapping("/accept")
    public ResponseEntity<PropositionFormation> acceptPropositionFormation(@RequestParam("idProposition") long idProposition) {
        PropositionFormation acceptedProposition = propositionFormationService.AccepterPropositionFormation(idProposition);
        if (acceptedProposition != null) {
            return new ResponseEntity<>(acceptedProposition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/refuser")
    public ResponseEntity<PropositionFormation> RefuserPropositionFormation(@RequestParam("idProposition") long idProposition) {
        PropositionFormation acceptedProposition = propositionFormationService.RefuserPropositionFormation(idProposition);
        if (acceptedProposition != null) {
            return new ResponseEntity<>(acceptedProposition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/delete/{idProposition}")
		public ResponseEntity<HttpResponse> deletePropositionFormation (@PathVariable("idProposition") Long idProposition) throws IOException{
    	propositionFormationService.deletePropositionFormation(idProposition);
    	return response( OK , "Proposition Formation a ete supprimer avec success ") ; 
	}
    
    private  ResponseEntity<HttpResponse> response (HttpStatus httpStatus , String message ){
		HttpResponse body = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase()	,message.toUpperCase() )  ;
		return new  ResponseEntity<>( body , httpStatus ) ;
	}
    
    
   

    
    
    
}