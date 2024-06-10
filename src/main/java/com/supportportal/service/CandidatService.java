package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Candidat;



public interface CandidatService {

    List<Candidat> getAllCandidats();

    Candidat getCandidatById(Long idCandidats);

    Candidat saveCandidat(Candidat candidat);

    void deleteCandidat(Long idCandidats);
}
