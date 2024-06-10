package com.supportportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "inscription_formation") // Adjust table name if needed
public class InscriptionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    private Long idInscription;
    private String module;
    private String annee;
    private String particisipants;
    private String departement;
    private String fonction;
    private String participation;
    private String feedback;
	public Long getIdInscription() {
		return idInscription;
	}
	public void setIdInscription(Long idInscription) {
		this.idInscription = idInscription;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getParticisipants() {
		return particisipants;
	}
	public void setParticisipants(String particisipants) {
		this.particisipants = particisipants;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getParticipation() {
		return participation;
	}
	public void setParticipation(String participation) {
		this.participation = participation;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public InscriptionFormation(Long idInscription, String module, String annee, String particisipants,
			String departement, String fonction, String participation, String feedback) {
		super();
		this.idInscription = idInscription;
		this.module = module;
		this.annee = annee;
		this.particisipants = particisipants;
		this.departement = departement;
		this.fonction = fonction;
		this.participation = participation;
		this.feedback = feedback;
	}
	public InscriptionFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}