package com.supportportal.service;

import java.util.Date;
import java.util.List;

import com.supportportal.entity.PropositionFormation;



public interface PropositionFormationService {
	
	List<PropositionFormation> getAllPropositionFormations();
    
    PropositionFormation getPropositionFormationById(Long idProposition);
     
	void deletePropositionFormation(Long idProposition);
	


	PropositionFormation RefuserPropositionFormation(Long idProposition);

	PropositionFormation ajouterPropositionFormation(String module, String type, String categorie, String description,
			String proposePar, String posteProposerPar, String cabinetpropo, String departemenet, String objectif,
			String activite, String observation, String formateurPropose, Date prdSouhaite, List<String> employeeNames);

	PropositionFormation AccepterPropositionFormation(Long idProposition);
		
}