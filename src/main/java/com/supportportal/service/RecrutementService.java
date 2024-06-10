package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Recrutement;



public interface RecrutementService {

    Recrutement saveRecrutement(Recrutement recrutement);
    List<Recrutement> findAllRecruitments();
    Recrutement findByIdRecrutement(Long idRecrutement);
    void deleteRecrutement(Long idRecrutement);
    Recrutement updateRecrutement(Recrutement recrutement); // Added update method
    	
}
