package com.supportportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.*;
import com.supportportal.service.StagierService;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = { "/stagier"})
public class StagierController {
	
	private StagierService stagierService ;

	@Autowired
	public StagierController(StagierService stagierService) {
		  this.stagierService =  stagierService ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Stagier> addNewStagier(  @RequestParam("nomPrenom") String nomPrenom ,
												   @RequestParam("institut") String institut , 
												   @RequestParam("diplome") String diplome ,
												   @RequestParam("specialite") String specialite ,
												   @RequestParam("cin") String cin ,
												   @RequestParam("tel") String tel ,
												   @RequestParam("superviseurMatricule") String superviseurMatricule,
												   @RequestParam("stageRef") String stageRef){
		Stagier newStagier = stagierService.ajouterStagier(nomPrenom, institut, diplome, specialite, cin,tel, superviseurMatricule, stageRef) ;
		return new  ResponseEntity<>(newStagier,OK);
	}

}
