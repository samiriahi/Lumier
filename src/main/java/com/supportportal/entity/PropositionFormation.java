package com.supportportal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "proposition_formation")
public class PropositionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idProposition;
    private String module;
    private String typePropo;
    private String categorie ;
    private String description;
    private String proposePar;
    private String posteProposerPar ;
    private String cabinetproposer; // non obligatoire
    private String departement ;
    private boolean isAccepted;
    private String status;
    private String objectif ;
    private String activite ;
    private String formateurPropose ; // non obligatoire
    private String Observation ; // non obligatoire
   
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date periodeSouhaite ;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date  DateCreation ;
    
    
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "propo_formation_participants",
        joinColumns = @JoinColumn(name = "propo_formation_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> participants;
  
    
	public PropositionFormation() {
		super();
	}
	
	

	public PropositionFormation(Long idProposition, String module, String typePropo, String categorie,
			String description, String proposePar, String posteProposerPar, String cabinetproposer, String departement,
			boolean isAccepted, String status, String objectif, String activite, String formateurPropose,
			String observation, Date periodeSouhaite, Date dateCreation, List<Employee> participants) {
		super();
		this.idProposition = idProposition;
		this.module = module;
		this.typePropo = typePropo;
		this.categorie = categorie;
		this.description = description;
		this.proposePar = proposePar;
		this.posteProposerPar = posteProposerPar;
		this.cabinetproposer = cabinetproposer;
		this.departement = departement;
		this.isAccepted = isAccepted;
		this.status = status;
		this.objectif = objectif;
		this.activite = activite;
		this.formateurPropose = formateurPropose;
		Observation = observation;
		this.periodeSouhaite = periodeSouhaite;
		DateCreation = dateCreation;
		this.participants = participants;
	}

	
	




	public String getFormateurPropose() {
		return formateurPropose;
	}



	public void setFormateurPropose(String formateurPropose) {
		this.formateurPropose = formateurPropose;
	}



	public String getObservation() {
		return Observation;
	}



	public void setObservation(String observation) {
		Observation = observation;
	}



	public Date getPeriodeSouhaite() {
		return periodeSouhaite;
	}



	public void setPeriodeSouhaite(Date periodeSouhaite) {
		this.periodeSouhaite = periodeSouhaite;
	}



	public Long getIdProposition() {
		return idProposition;
	}


	public void setIdProposition(Long idProposition) {
		this.idProposition = idProposition;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getTypePropo() {
		return typePropo;
	}


	public void setTypePropo(String typePropo) {
		this.typePropo = typePropo;
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


	public boolean isAccepted() {
		return isAccepted;
	}


	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public Date getDateCreation() {
		return DateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}


	public List<Employee> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Employee> participants) {
		this.participants = participants;
	}

		
 
    
  }