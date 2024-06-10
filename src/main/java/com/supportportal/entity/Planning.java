package com.supportportal.entity;


import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanning;
    private String module;
    private String departement;
    private String type;
    private String categorie ;
    private String demandeur;
    private String posteProposerPar ;
    private String cabinetproposer; // vide
    private String objectif ;
    private String activite ;
    private String formateur ; // 
    private String observation ; // non obligatoire
    private String budgetPrevisionnel ;
    private String budgetEstimatif ;
    private String statusPlannig ;
    private String coutreel ;
       
    private String evaluationChaud ;
    private String evaluationFroid ;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateRealisation ; // 22 / 05 /2024
    
    
    @JsonBackReference
    @OneToOne(mappedBy = "planning")
    private Formation formation;

    
    
	public Planning() {
		super();
	}
	


	public Planning(Long idPlanning, String module, String departement, String type, String categorie, String demandeur,
			String posteProposerPar, String cabinetproposer, String objectif, String activite, String formateur,
			String observation, String budgetPrevisionnel, String budgetEstimatif, String statusPlannig,
			String coutreel, String evaluationChaud, String evaluationFroid, Date dateRealisation,
			Formation formation) {
		super();
		this.idPlanning = idPlanning;
		this.module = module;
		this.departement = departement;
		this.type = type;
		this.categorie = categorie;
		this.demandeur = demandeur;
		this.posteProposerPar = posteProposerPar;
		this.cabinetproposer = cabinetproposer;
		this.objectif = objectif;
		this.activite = activite;
		this.formateur = formateur;
		this.observation = observation;
		this.budgetPrevisionnel = budgetPrevisionnel;
		this.budgetEstimatif = budgetEstimatif;
		this.statusPlannig = statusPlannig;
		this.coutreel = coutreel;
		this.evaluationChaud = evaluationChaud;
		this.evaluationFroid = evaluationFroid;
		this.dateRealisation = dateRealisation;
		this.formation = formation;
	}




	public Long getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(Long idPlanning) {
		this.idPlanning = idPlanning;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(String demandeur) {
		this.demandeur = demandeur;
	}

	public String getPosteProposerPar() {
		return posteProposerPar;
	}

	public void setPosteProposerPar(String posteProposerPar) {
		this.posteProposerPar = posteProposerPar;
	}

	public String getCabinetproposer() {
		return cabinetproposer;
	}

	public void setCabinetproposer(String cabinetproposer) {
		this.cabinetproposer = cabinetproposer;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getFormateur() {
		return formateur;
	}

	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getBudgetPrevisionnel() {
		return budgetPrevisionnel;
	}

	public void setBudgetPrevisionnel(String budgetPrevisionnel) {
		this.budgetPrevisionnel = budgetPrevisionnel;
	}

	public String getBudgetEstimatif() {
		return budgetEstimatif;
	}

	public void setBudgetEstimatif(String budgetEstimatif) {
		this.budgetEstimatif = budgetEstimatif;
	}

	public String getStatusPlannig() {
		return statusPlannig;
	}

	public void setStatusPlannig(String statusPlannig) {
		this.statusPlannig = statusPlannig;
	}

	public String getCoutreel() {
		return coutreel;
	}

	public void setCoutreel(String coutreel) {
		this.coutreel = coutreel;
	}

	public String getEvaluationChaud() {
		return evaluationChaud;
	}

	public void setEvaluationChaud(String evaluationChaud) {
		this.evaluationChaud = evaluationChaud;
	}

	public String getEvaluationFroid() {
		return evaluationFroid;
	}

	public void setEvaluationFroid(String evaluationFroid) {
		this.evaluationFroid = evaluationFroid;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	
    
    
    
 

   
}