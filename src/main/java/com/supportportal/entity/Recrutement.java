package com.supportportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "recrutement") 
public class Recrutement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idRecrutement;

    @Column(name = "idjob")
    private Long idJob; 

    private String departement;
    private String emploidemande;
    private String recruteur;
    private String nomCondidat;
    
    @Enumerated
    private Source source;
    
    private String datedemande;
    @Enumerated
    private PhaseSelection phaseselection;
    
    @Enumerated
    private Decision desision;
    
    @Enumerated
    private Vue vueGestionaire;
    
    @Enumerated
    private Vue vuedecideur;
    
    @Enumerated
    private Vue vuerh;
    
    private String commentaire;
	public Long getIdRecrutement() {
		return idRecrutement;
	}
	public void setIdRecrutement(Long idRecrutement) {
		this.idRecrutement = idRecrutement;
	}
	public Long getIdJob() {
		return idJob;
	}
	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getEmploidemande() {
		return emploidemande;
	}
	public void setEmploidemande(String emploidemande) {
		this.emploidemande = emploidemande;
	}
	public String getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(String recruteur) {
		this.recruteur = recruteur;
	}
	public String getNomCondidat() {
		return nomCondidat;
	}
	public void setNomCondidat(String nomCondidat) {
		this.nomCondidat = nomCondidat;
	}
	
	public String getDatedemande() {
		return datedemande;
	}
	public void setDatedemande(String datedemande) {
		this.datedemande = datedemande;
	}
	
	
	
	public PhaseSelection getPhaseselection() {
		return phaseselection;
	}
	public void setPhaseselection(PhaseSelection phaseselection) {
		this.phaseselection = phaseselection;
	}
	
	public Decision getDesision() {
		return desision;
	}
	public void setDesision(Decision desision) {
		this.desision = desision;
	}
	
	public Vue getVueGestionaire() {
		return vueGestionaire;
	}
	public void setVueGestionaire(Vue vueGestionaire) {
		this.vueGestionaire = vueGestionaire;
	}
	public Vue getVuedecideur() {
		return vuedecideur;
	}
	public void setVuedecideur(Vue vuedecideur) {
		this.vuedecideur = vuedecideur;
	}
	public Vue getVuerh() {
		return vuerh;
	}
	public void setVuerh(Vue vuerh) {
		this.vuerh = vuerh;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	
	
	public Recrutement(Long idRecrutement, Long idJob, String departement, String emploidemande, String recruteur,
			String nomCondidat, Source source, String datedemande, PhaseSelection phaseselection, Decision desision,
			Vue vueGestionaire, Vue vuedecideur, Vue vuerh, String commentaire) {
		super();
		this.idRecrutement = idRecrutement;
		this.idJob = idJob;
		this.departement = departement;
		this.emploidemande = emploidemande;
		this.recruteur = recruteur;
		this.nomCondidat = nomCondidat;
		this.source = source;
		this.datedemande = datedemande;
		this.phaseselection = phaseselection;
		this.desision = desision;
		this.vueGestionaire = vueGestionaire;
		this.vuedecideur = vuedecideur;
		this.vuerh = vuerh;
		this.commentaire = commentaire;
	}
	public Recrutement() {
		super();
		// TODO Auto-generated constructor stub
	}

 
}