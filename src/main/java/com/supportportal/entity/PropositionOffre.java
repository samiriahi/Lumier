package com.supportportal.entity;

import java.sql.Date;


import javax.persistence.*;

@Entity
public class PropositionOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreProp;
    
    private String departement;
    
    private String jobTitle;
    
    private Date dateLancement;
    
    private Date dateEmbauche;
    
    private Double coutEmbauche;
    
    private Integer duree;
    
    private String motiveRecretement;
      
    @Enumerated
    private PropositionOffreRecruteur recruteur; 
        
    
    @Enumerated
    private PropositionOffreMode modeRecretement;
    
    @Enumerated
    private PropositionOffreStatus status;

    
    
    
    
	public Long getIdOffreProp() {
		return idOffreProp;
	}

	public void setIdOffreProp(Long idOffreProp) {
		this.idOffreProp = idOffreProp;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDateLancement() {
		return dateLancement;
	}

	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Double getCoutEmbauche() {
		return coutEmbauche;
	}

	public void setCoutEmbauche(Double coutEmbauche) {
		this.coutEmbauche = coutEmbauche;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getMotiveRecretement() {
		return motiveRecretement;
	}

	public void setMotiveRecretement(String motiveRecretement) {
		this.motiveRecretement = motiveRecretement;
	}

	public PropositionOffreRecruteur getRecruteur() {
		return recruteur;
	}

	public void setRecruteur(PropositionOffreRecruteur recruteur) {
		this.recruteur = recruteur;
	}

	public PropositionOffreMode getModeRecretement() {
		return modeRecretement;
	}

	public void setModeRecretement(PropositionOffreMode modeRecretement) {
		this.modeRecretement = modeRecretement;
	}

	public PropositionOffreStatus getStatus() {
		return status;
	}

	public void setStatus(PropositionOffreStatus status) {
		this.status = status;
	}
    
   
	

    
    
}