package com.supportportal.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "formation") 
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idFormation;
    private String module;
    private String type;
    private String categorie ;
    private String description;
    private String proposePar;
    private String posteProposerPar ;
    private String cabinetproposer; // non obligatoire
    private String departement ;
    private String objectif ;
    private String activite ;
    private String formateurPropose ; // non obligatoire
    private String observation ; // non obligatoire
    private String budgetPrevisionnel ; 
    
    
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPlanning", referencedColumnName = "idPlanning")
    private Planning planning;
    
    
    
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "formation_participants",
        joinColumns = @JoinColumn(name = "formation_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> participants;

    

	public Formation() {
		super();
	}

    
	public Formation(Long idFormation, String module, String type, String categorie, String description,
			String proposePar, String posteProposerPar, String cabinetproposer, String departement, String objectif,
			String activite, String formateurPropose, String observation, String budgetPrevisionnel, Planning planning,
			List<Employee> participants) {
		super();
		this.idFormation = idFormation;
		this.module = module;
		this.type = type;
		this.categorie = categorie;
		this.description = description;
		this.proposePar = proposePar;
		this.posteProposerPar = posteProposerPar;
		this.cabinetproposer = cabinetproposer;
		this.departement = departement;
		this.objectif = objectif;
		this.activite = activite;
		this.formateurPropose = formateurPropose;
		this.observation = observation;
		this.budgetPrevisionnel = budgetPrevisionnel;
		this.planning = planning;
		this.participants = participants;
	}





	public Long getIdFormation() {
		return idFormation;
	}



	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}



	public String getModule() {
		return module;
	}



	public void setModule(String module) {
		this.module = module;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getProposePar() {
		return proposePar;
	}



	public void setProposePar(String proposePar) {
		this.proposePar = proposePar;
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



	public String getDepartement() {
		return departement;
	}



	public void setDepartement(String departement) {
		this.departement = departement;
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



	public String getFormateurPropose() {
		return formateurPropose;
	}



	public void setFormateurPropose(String formateurPropose) {
		this.formateurPropose = formateurPropose;
	}



	public String getObservation() {
		return observation;
	}



	public void setObservation(String observation) {
		observation = observation;
	}



	public String getBudgetPrevisionnel() {
		return budgetPrevisionnel;
	}



	public void setBudgetPrevisionnel(String budgetPrevisionnel) {
		this.budgetPrevisionnel = budgetPrevisionnel;
	}



	public Planning getPlanning() {
		return planning;
	}



	public void setPlanning(Planning planning) {
		this.planning = planning;
	}



	public List<Employee> getParticipants() {
		return participants;
	}



	public void setParticipants(List<Employee> participants) {
		this.participants = participants;
	}
    
    
}