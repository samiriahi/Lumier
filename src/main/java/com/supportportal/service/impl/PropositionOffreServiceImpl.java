package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.PropositionOffre;
import com.supportportal.repository.PropositionOffreRepository;
import com.supportportal.service.PropositionOffreService;



@Service
public class PropositionOffreServiceImpl implements PropositionOffreService {

  @Autowired
  private PropositionOffreRepository propositionOffreRepository;

  @Override
  public PropositionOffre savePropositionOffre(PropositionOffre propositionOffre) {
    return propositionOffreRepository.save(propositionOffre);
  }

  @Override
  public List<PropositionOffre> getAllPropositionOffres() {
    return propositionOffreRepository.findAll();
  }

  @Override
  public PropositionOffre getPropositionOffreById(Long id) {
    return propositionOffreRepository.findById(id).get();
  }

  @Override
  public void deletePropositionOffre(Long id) {
    propositionOffreRepository.deleteById(id);
  }

  @Override
  public PropositionOffre updatePropositionOffre(PropositionOffre propositionOffre) {
  
    PropositionOffre existingProposition = propositionOffreRepository.findById(propositionOffre.getIdOffreProp()).get();

    existingProposition.setDepartement(propositionOffre.getDepartement());
    existingProposition.setJobTitle(propositionOffre.getJobTitle());

    return propositionOffreRepository.save(existingProposition);
  }



}