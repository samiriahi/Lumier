package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.InscriptionFormation;


public interface InscriptionFormationService {
	  InscriptionFormation saveInscriptionFormation(InscriptionFormation inscriptionFormation);
	    List<InscriptionFormation> findAllInscriptionFormations();
	    InscriptionFormation findByIdInscription(Long idInscription);
	    void deleteInscriptionFormation(Long idInscription); // Assuming soft deletion is not required
	    InscriptionFormation updateInscriptionFormation(InscriptionFormation inscriptionFormation); // Added update method
	    // Add other service methods as needed (e.g., find by participant name)
	}