package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Formation;
import com.supportportal.entity.Planning;



public interface FormationService {

	    List<Formation> findAllFormations();
	    
	    Formation findByIdFormation(Long idFormation);
	    
	    void deleteFormation(Long idFormation);
	    	
		
		Formation affecterEmployeesToFormation(Long formationId, List<String> employeeNames);

		Formation updateFormation(Long idFormation, String module, String type, String categorie, String description,
				String proposePar, String posteProposerPar, String cabinetproposer, String departement, String objectif,
				String activite, String formateurPropose, String observation, String budgetPrevisionnel);

		Planning addFormationToPlanning(Long idFormation);
	
	}