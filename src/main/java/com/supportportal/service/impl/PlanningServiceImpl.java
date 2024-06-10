package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Formation;
import com.supportportal.entity.Planning;
import com.supportportal.enumeration.EvaluationChaudFroid;
import com.supportportal.enumeration.StatusPlannig;
import com.supportportal.repository.FormationRepository;
import com.supportportal.repository.PlanningRepository;
import com.supportportal.service.PlanningService;

import java.util.Date;

@Service
public class PlanningServiceImpl implements PlanningService {

    @Autowired
    private PlanningRepository planningRepository;
    
    @Autowired
    private FormationRepository formationRepository;

	@Override
    public List<Planning> findAllPlannings() {
        return planningRepository.findAll();
    }

    @Override
    public Planning findByIdPlanning(Long idPlanning) {
        return planningRepository.findById(idPlanning).orElse(null);
    }

    
    @Override
  	public Planning updatePlanning(Long idPlanning, String module, String departement, String type, String categorie,
              String demandeur, String posteProposerPar, String cabinetproposer, String objectif,
              String activite, String formateur, String observation, String budgetPrevisionnel,
              String budgetEstimatif, String statusPlanning, String coutreel,
              String evaluationChaud, String evaluationFroid ,  Date dateRealisation ) {
  	    
      	Planning existingPlanning = planningRepository.findById(idPlanning).orElse(null);
  	    
  	    
      	 if (existingPlanning != null) {
      	        existingPlanning.setModule(module);
      	        existingPlanning.setDepartement(departement);
      	        existingPlanning.setType(type);
      	        existingPlanning.setCategorie(categorie);
      	        existingPlanning.setDemandeur(demandeur);
      	        existingPlanning.setPosteProposerPar(posteProposerPar);
      	        existingPlanning.setCabinetproposer(cabinetproposer);
      	        existingPlanning.setObjectif(objectif);
      	        existingPlanning.setActivite(activite);
      	        existingPlanning.setFormateur(formateur);
      	        existingPlanning.setObservation(observation);
      	        existingPlanning.setBudgetPrevisionnel(budgetPrevisionnel);
      	        existingPlanning.setBudgetEstimatif(budgetEstimatif);
      	        existingPlanning.setStatusPlannig(statusPlanning);
      	        existingPlanning.setCoutreel(coutreel);
      	        existingPlanning.setEvaluationChaud(evaluationChaud);
      	        existingPlanning.setEvaluationFroid(evaluationFroid);
      	        existingPlanning.setDateRealisation(dateRealisation);
  	    
      	        planningRepository.save(existingPlanning);
      	        return existingPlanning;
      	    } else {
      	        System.out.println("Aucun planning avec l'ID " + idPlanning + " trouvé.");
      	        return null ;
      	    }
  	}

    
    @Override
    public void deletePlanning(Long idPlanning) {
        planningRepository.deleteById(idPlanning);
    }
    
    
    


}
