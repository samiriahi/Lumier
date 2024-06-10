package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.OffreEmploi;



public interface OffreEmploiService {

    List<OffreEmploi> getAllOffresEmploi();

    OffreEmploi getOffreEmploiById(Long idOffreEmploi);

    OffreEmploi saveOffreEmploi(OffreEmploi offreEmploi);

    void deleteOffreEmploi(Long idOffreEmploi);
}