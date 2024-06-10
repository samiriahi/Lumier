package com.supportportal.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.Candidat;
import com.supportportal.repository.CandidatRepository;
import com.supportportal.service.CandidatService;



@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Override
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat getCandidatById(Long idCandidats) {
        return candidatRepository.findById(idCandidats).orElse(null);
    }

    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public void deleteCandidat(Long idCandidats) {
        candidatRepository.deleteById(idCandidats);
    }
}