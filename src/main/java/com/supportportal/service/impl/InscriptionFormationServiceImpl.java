package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.InscriptionFormation;
import com.supportportal.repository.InscriptionFormationRepository;
import com.supportportal.service.InscriptionFormationService;


@Service
public class InscriptionFormationServiceImpl implements InscriptionFormationService {

    @Autowired
    private InscriptionFormationRepository inscriptionFormationRepository;

    @Override
    public InscriptionFormation saveInscriptionFormation(InscriptionFormation inscriptionFormation) {
        return inscriptionFormationRepository.save(inscriptionFormation);
    }

    @Override
    public List<InscriptionFormation> findAllInscriptionFormations() {
        return inscriptionFormationRepository.findAll();
    }

    @Override
    public InscriptionFormation findByIdInscription(Long idInscription) {
        return inscriptionFormationRepository.findById(idInscription).orElse(null);
    }

    @Override
    public void deleteInscriptionFormation(Long idInscription) {
        inscriptionFormationRepository.deleteById(idInscription);
    }
    @Override
    public InscriptionFormation updateInscriptionFormation(InscriptionFormation inscriptionFormation) {
        // Retrieve the existing inscriptionFormation by ID
        InscriptionFormation existingInscriptionFormation = inscriptionFormationRepository.findById(inscriptionFormation.getIdInscription()).orElse(null);

        // Check if the inscriptionFormation exists before updating
        if (existingInscriptionFormation != null) {
            // Update properties from the provided inscriptionFormation object
            existingInscriptionFormation.setModule(inscriptionFormation.getModule());
            existingInscriptionFormation.setAnnee(inscriptionFormation.getAnnee());
            existingInscriptionFormation.setParticisipants(inscriptionFormation.getParticisipants());
            existingInscriptionFormation.setDepartement(inscriptionFormation.getDepartement());
            existingInscriptionFormation.setFonction(inscriptionFormation.getFonction());
            existingInscriptionFormation.setParticipation(inscriptionFormation.getParticipation());
            existingInscriptionFormation.setFeedback(inscriptionFormation.getFeedback());

            // Save the updated inscriptionFormation
            return inscriptionFormationRepository.save(existingInscriptionFormation);
        } else {
            // Throw an exception or return null if the inscriptionFormation is not found
            throw new RuntimeException("InscriptionFormation with ID " + inscriptionFormation.getIdInscription() + " not found for update.");
        }
    }
}