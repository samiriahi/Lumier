package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.Planning;



public interface PlanningService {


	List<Planning> findAllPlannings();

	Planning findByIdPlanning(Long idPlanning);


	void deletePlanning(Long idPlanning);

	Planning updatePlanning(Long idPlanning, String module, String departement, String type, String categorie,
			String demandeur, String posteProposerPar, String cabinetproposer, String objectif, String activite,
			String formateur, String observation, String budgetPrevisionnel, String budgetEstimatif,
			String statusPlanning, String coutreel, String evaluationChaud, String evaluationFroid,
			Date dateRealisation);

	

    
}