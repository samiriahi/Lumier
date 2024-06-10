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

import com.supportportal.entity.PropositionOffre;
import com.supportportal.service.PropositionOffreService;


@RestController
@RequestMapping("/propositionOffres")
public class PropositionOffreController {

  @Autowired
  private PropositionOffreService propositionOffreService;

  @PostMapping("/add")
  public PropositionOffre savePropositionOffre(@RequestBody PropositionOffre propositionOffre) {
    return propositionOffreService.savePropositionOffre(propositionOffre);
  }

  @GetMapping("/getall")
  public List<PropositionOffre> getAllPropositionOffres() {
    return propositionOffreService.getAllPropositionOffres();
  }

  @GetMapping("/getone/{id}")
  public PropositionOffre getPropositionOffreById(@PathVariable Long id) {
    return propositionOffreService.getPropositionOffreById(id);
  }

  @DeleteMapping("/delete/{id}")
  public void deletePropositionOffre(@PathVariable Long id) {
    propositionOffreService.deletePropositionOffre(id);
  }

  @PutMapping("/update/{id}")
  public PropositionOffre updatePropositionOffre(@PathVariable Long id, @RequestBody PropositionOffre propositionOffre) {
    propositionOffre.setIdOffreProp(id); 
    return propositionOffreService.updatePropositionOffre(propositionOffre);
  }

}