package com.supportportal.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreEmploi;
    private String departement;
    private String jobTitre;
    private Date dateLancement;
    @Enumerated
    private PropositionOffreRecruteur recruteur; 
    
    private String motifRecrutement;
    @Enumerated
    private PropositionOffreMode modeRecretement;
    
    @Enumerated
    private PropositionOffreStatus status;
    
    private Date dateEmbauche;
    private Double coutEmbauche; 
    private String duree; 
    
    @OneToMany(mappedBy = "offreEmploi") // OneToMany relationship with PropositionOffre
    private Set<PropositionOffre> propositions;
    
    
    
    @ManyToMany(mappedBy = "offresEmploi") // ManyToMany relationship with Candidat (mappedBy for clarity)
    private Set<Candidat> candidatures;



	public Long getIdOffreEmploi() {
		return idOffreEmploi;
	}



	public void setIdOffreEmploi(Long idOffreEmploi) {
		this.idOffreEmploi = idOffreEmploi;
	}



	public String getDepartement() {
		return departement;
	}



	public void setDepartement(String departement) {
		this.departement = departement;
	}



	public String getJobTitre() {
		return jobTitre;
	}



	public void setJobTitre(String jobTitre) {
		this.jobTitre = jobTitre;
	}



	public Date getDateLancement() {
		return dateLancement;
	}



	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}



	public PropositionOffreRecruteur getRecruteur() {
		return recruteur;
	}



	public void setRecruteur(PropositionOffreRecruteur recruteur) {
		this.recruteur = recruteur;
	}



	public String getMotifRecrutement() {
		return motifRecrutement;
	}



	public void setMotifRecrutement(String motifRecrutement) {
		this.motifRecrutement = motifRecrutement;
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



	public String getDuree() {
		return duree;
	}



	public void setDuree(String duree) {
		this.duree = duree;
	}



	public Set<PropositionOffre> getPropositions() {
		return propositions;
	}



	public void setPropositions(Set<PropositionOffre> propositions) {
		this.propositions = propositions;
	}



	public Set<Candidat> getCandidatures() {
		return candidatures;
	}



	public void setCandidatures(Set<Candidat> candidatures) {
		this.candidatures = candidatures;
	}



	public OffreEmploi(Long idOffreEmploi, String departement, String jobTitre, Date dateLancement,
			PropositionOffreRecruteur recruteur, String motifRecrutement, PropositionOffreMode modeRecretement,
			PropositionOffreStatus status, Date dateEmbauche, Double coutEmbauche, String duree,
			Set<PropositionOffre> propositions, Set<Candidat> candidatures) {
		super();
		this.idOffreEmploi = idOffreEmploi;
		this.departement = departement;
		this.jobTitre = jobTitre;
		this.dateLancement = dateLancement;
		this.recruteur = recruteur;
		this.motifRecrutement = motifRecrutement;
		this.modeRecretement = modeRecretement;
		this.status = status;
		this.dateEmbauche = dateEmbauche;
		this.coutEmbauche = coutEmbauche;
		this.duree = duree;
		this.propositions = propositions;
		this.candidatures = candidatures;
	}



	public OffreEmploi() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	

}