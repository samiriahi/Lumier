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

import com.supportportal.entity.OffreEmploi;
import com.supportportal.service.OffreEmploiService;



@RestController
@RequestMapping("/offresEmploi")
public class OffreEmploiController {

    @Autowired
    private OffreEmploiService offreEmploiService;

    @GetMapping("/getall")
    public List<OffreEmploi> getAllOffresEmploi() {
        return offreEmploiService.getAllOffresEmploi();
    }

    @GetMapping("/{idOffreEmploi}")
    public OffreEmploi getOffreEmploiById(@PathVariable Long idOffreEmploi) {
        return offreEmploiService.getOffreEmploiById(idOffreEmploi);
    }

    @PostMapping("/add")
    public OffreEmploi saveOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        return offreEmploiService.saveOffreEmploi(offreEmploi);
    }

    @PutMapping("/{idOffreEmploi}")
    public OffreEmploi updateOffreEmploi(@PathVariable Long idOffreEmploi, @RequestBody OffreEmploi offreEmploi) {
              offreEmploi.setIdOffreEmploi(idOffreEmploi);
        return offreEmploiService.saveOffreEmploi(offreEmploi);
    }

    @DeleteMapping("/{idOffreEmploi}")
    public void deleteOffreEmploi(@PathVariable Long idOffreEmploi) {
        offreEmploiService.deleteOffreEmploi(idOffreEmploi);
    }
}