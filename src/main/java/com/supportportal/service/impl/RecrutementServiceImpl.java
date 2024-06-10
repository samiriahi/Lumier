package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Recrutement;
import com.supportportal.repository.RecrutementRepository;
import com.supportportal.service.RecrutementService;



@Service
public class RecrutementServiceImpl implements RecrutementService {

    @Autowired
    private RecrutementRepository recrutementRepository;

    @Override
    public Recrutement saveRecrutement(Recrutement recrutement) {
        return recrutementRepository.save(recrutement);
    }

    @Override
    public List<Recrutement> findAllRecruitments() {
        return recrutementRepository.findAll();
    }

    @Override
    public Recrutement findByIdRecrutement(Long idRecrutement) {
        return recrutementRepository.findById(idRecrutement).orElse(null);
    }

    @Override
    public void deleteRecrutement(Long idRecrutement) {
        recrutementRepository.deleteById(idRecrutement);
    }
    @Override
    public Recrutement updateRecrutement(Recrutement recrutement) {
        Recrutement existingRecrutement = recrutementRepository.findById(recrutement.getIdRecrutement()).orElse(null);
        if (existingRecrutement != null) {
            existingRecrutement.setIdJob(recrutement.getIdJob());
            existingRecrutement.setDepartement(recrutement.getDepartement());
            existingRecrutement.setEmploidemande(recrutement.getEmploidemande());
            existingRecrutement.setRecruteur(recrutement.getRecruteur());
            existingRecrutement.setNomCondidat(recrutement.getNomCondidat());
            existingRecrutement.setSource(recrutement.getSource());
            existingRecrutement.setDatedemande(recrutement.getDatedemande());
            existingRecrutement.setPhaseselection(recrutement.getPhaseselection());
            existingRecrutement.setDesision(recrutement.getDesision());
            existingRecrutement.setVueGestionaire(recrutement.getVueGestionaire());
            existingRecrutement.setVuedecideur(recrutement.getVuedecideur());
            existingRecrutement.setVuedecideur(recrutement.getVuedecideur());
            existingRecrutement.setVuerh(recrutement.getVuerh());
            existingRecrutement.setCommentaire(recrutement.getCommentaire());
            return recrutementRepository.save(existingRecrutement);
        } else {
            throw new RuntimeException("Recrutement with ID " + recrutement.getIdRecrutement() + " not found for update.");
        }
    }
}