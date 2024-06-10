package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.PropositionOffre;



public interface PropositionOffreService {

	  public PropositionOffre savePropositionOffre(PropositionOffre propositionOffre);
	  public List<PropositionOffre> getAllPropositionOffres();
	  public PropositionOffre getPropositionOffreById(Long id);
	  public void deletePropositionOffre(Long id);
	  public PropositionOffre updatePropositionOffre(PropositionOffre propositionOffre);
	}