package com.supportportal.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Employee;
import com.supportportal.entity.Formation;
import com.supportportal.entity.Planning;
import com.supportportal.enumeration.EvaluationChaudFroid;
import com.supportportal.enumeration.StatusPlannig;
import com.supportportal.repository.EmployeeRepository;
import com.supportportal.repository.FormationRepository;
import com.supportportal.repository.PlanningRepository;
import com.supportportal.service.FormationService;



@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired 
    private PlanningRepository planningRepository;
    
    
    @Override
    public List<Formation> findAllFormations() {
        return formationRepository.findAll();
    }
    
    @Override
    public Formation findByIdFormation(Long idFormation) {
        return formationRepository.findById(idFormation).orElse(null);
    }
    
    @Override
    public Formation updateFormation(Long idFormation, String module, String type, String categorie, String description,
                                     String proposePar, String posteProposerPar, String cabinetproposer, String departement,
                                     String objectif, String activite, String formateurPropose, String observation,
                                     String budgetPrevisionnel) {
       
    	 Formation existedFormation = formationRepository.findById(idFormation).orElse(null);
        
        if (existedFormation != null) {
       
            existedFormation.setModule(module);
            existedFormation.setType(type);
            existedFormation.setCategorie(categorie);
            existedFormation.setDescription(description);
            existedFormation.setProposePar(proposePar);
            existedFormation.setPosteProposerPar(posteProposerPar);
            existedFormation.setCabinetproposer(cabinetproposer);
            existedFormation.setDepartement(departement);
            existedFormation.setObjectif(objectif);
            existedFormation.setActivite(activite);
            existedFormation.setFormateurPropose(formateurPropose);
            existedFormation.setObservation(observation);
            existedFormation.setBudgetPrevisionnel(budgetPrevisionnel);

            formationRepository.save(existedFormation);
            return existedFormation;
            
        } else {
            System.out.println("Aucune formation avec l'ID " + idFormation + " trouvée.");
            return null;
        }
    }

    
	public Formation affecterEmployeesToFormation(Long formationId, List<String> employeeNames) {
        Formation formation = formationRepository.findById(formationId).orElse(null);

        if (formation == null) {
            throw new EntityNotFoundException("Formation not found");
        }

        for (String employeeName : employeeNames) {
            Employee employee = employeeRepository.findByNomPrenom(employeeName).orElse(null);

            if (employee == null) {
                throw new EntityNotFoundException("Employee " + employeeName + " not found");
            }

            formation.getParticipants().add(employee);
        }

        return formationRepository.save(formation);
    }
	
	

	@Override
    public void deleteFormation(Long idFormation) {
        formationRepository.deleteById(idFormation);
    }
	
	
	@Override
	public Planning addFormationToPlanning( Long  idFormation) {
	    
		 Formation formation = formationRepository.findById(idFormation).orElse(null);
	    
		 Planning planning = new Planning();
	    
	    planning.setModule(formation.getModule());
	    planning.setDepartement(formation.getDepartement());
	    planning.setType(formation.getType());
	    planning.setCategorie(formation.getCategorie());
	    planning.setDemandeur(formation.getProposePar());
	    planning.setPosteProposerPar(formation.getPosteProposerPar());
	    planning.setCabinetproposer(formation.getCabinetproposer());
	    planning.setObjectif(formation.getObjectif());
	    planning.setActivite(formation.getActivite());
	    planning.setFormateur(formation.getFormateurPropose());
	    planning.setObservation(formation.getObservation());
	    planning.setBudgetPrevisionnel(formation.getBudgetPrevisionnel());
	    
	    planning.setCoutreel("00.00");
	    planning.setBudgetEstimatif("00.00");
	    planning.setDateRealisation(null);
	    planning.setStatusPlannig(StatusPlannig.PLANNIFE.name());
	    planning.setEvaluationChaud(EvaluationChaudFroid.NON_CLOTURE.name());
	    planning.setEvaluationFroid(EvaluationChaudFroid.NON_CLOTURE.name());
	   
	    // Lier la formation au planning si elle est fournie
	    if (formation != null) {
	        planning.setFormation(formation);
	        formation.setPlanning(planning);
	    }

	    planningRepository.save(planning);
	    
	    return planning;
	}
 
}