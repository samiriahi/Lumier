package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.Candidat;
import com.supportportal.service.CandidatService;



@RestController
@RequestMapping("/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public List<Candidat> getAllCandidats() {
        return candidatService.getAllCandidats();
    }

    @GetMapping("/{idCandidats}")
    public Candidat getCandidatById(@PathVariable Long idCandidats) {
        return candidatService.getCandidatById(idCandidats);
    }

    @PostMapping
    public Candidat saveCandidat(@RequestBody Candidat candidat) {
        return candidatService.saveCandidat(candidat);
    }

    @PutMapping("/{idCandidats}")
    public Candidat updateCandidat(@PathVariable Long idCandidats, @RequestBody Candidat candidat) {
        
        candidat.setIdCandidats(idCandidats);
        return candidatService.saveCandidat(candidat);
    }

    @DeleteMapping("/{idCandidats}")
    public void deleteCandidat(@PathVariable Long idCandidats) {
        candidatService.deleteCandidat(idCandidats);
    }
}