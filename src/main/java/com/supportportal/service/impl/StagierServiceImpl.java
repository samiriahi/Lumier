package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Employee;
import com.supportportal.entity.Stage;
import com.supportportal.entity.Stagier;
import com.supportportal.repository.EmployeeRepository;
import com.supportportal.repository.StageRepository;
import com.supportportal.repository.StagierRepository;
import com.supportportal.service.StagierService;



@Service
public class StagierServiceImpl implements StagierService {

    @Autowired
    private StagierRepository stagierRepository;
    
    @Autowired
    private StageRepository stageRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Stagier> getAllStagiers() {
        return stagierRepository.findAll();
    }

    @Override
    public Stagier getStagierById(Long idStagier) {
        return stagierRepository.findById(idStagier).orElse(null);
    }

    
    @Override
    public Stagier ajouterStagier(String nomPrenom, String institut, String diplome, String specialite,
            String cin, String tel, String superviseurMatricule, String stageRef) {
	
		Stagier stagier = new Stagier();
		Employee superviseur = employeeRepository.findEmployeeByMat(superviseurMatricule);
		
		Stage stage = stageRepository.findStageByReference(stageRef);
		
		stagier.setNomPrenom(nomPrenom);
		stagier.setInstitut(institut);
		stagier.setDiplome(diplome);
		stagier.setSpecialite(specialite);
		stagier.setCin(cin);
		stagier.setTel(tel);
		stagier.setStage(stage);
		stagier.setSuperviseur(superviseur);
		return stagier;
    }
    
    
    @Override
    public Stagier updateStagier(String cin, String nomPrenom, String institut, String diplome, String specialite,
            String tel, String superviseurMatricule, String stageRef) {
	
		Stagier stagier = stagierRepository.findStagierByCin(cin);
		Employee superviseur = employeeRepository.findEmployeeByMat(superviseurMatricule);
		Stage stage = stageRepository.findStageByReference(stageRef);
		
		if (stagier != null) {
			stagier.setNomPrenom(nomPrenom);
			stagier.setInstitut(institut);
			stagier.setDiplome(diplome);
			stagier.setSpecialite(specialite);
			stagier.setCin(cin);
			stagier.setTel(tel);
			stagier.setStage(stage);
			stagier.setSuperviseur(superviseur);
			
			return stagier;
		} else {
			System.out.println("Aucun stagiaire avec le CIN " + cin + " trouvé.");
			return null;
		}
    }



    @Override
    public void deleteStagier(Long idStagier) {
        stagierRepository.deleteById(idStagier);
    }

}