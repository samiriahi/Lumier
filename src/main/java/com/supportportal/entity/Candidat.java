package com.supportportal.entity;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;




@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidats;
    private Date date;
    private String cin;
    private String nomPrenom;
    private String tel;
    private String adresse;
    private String niveau;
    private String diplome;
    private String famille;
    private String postPropose;
    private String contact;
    private String observation;
    
    @ManyToMany // ManyToMany relationship with OffreEmploi
    @JoinTable(name = "offreemploi_candidat", // Join table for the relationship
        joinColumns = @JoinColumn(name = "idCandidat"),
        inverseJoinColumns = @JoinColumn(name = "idOffreEmploi"))
    private Set<OffreEmploi> offresEmploi;
    
    
    
	public Long getIdCandidats() {
		return idCandidats;
	}
	public void setIdCandidats(Long idCandidats) {
		this.idCandidats = idCandidats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public String getPostPropose() {
		return postPropose;
	}
	public void setPostPropose(String postPropose) {
		this.postPropose = postPropose;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Candidat(Long idCandidats, Date date, String cin, String nomPrenom, String tel, String adresse,
			String niveau, String diplome, String famille, String postPropose, String contact, String observation) {
		super();
		this.idCandidats = idCandidats;
		this.date = date;
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.tel = tel;
		this.adresse = adresse;
		this.niveau = niveau;
		this.diplome = diplome;
		this.famille = famille;
		this.postPropose = postPropose;
		this.contact = contact;
		this.observation = observation;
	}
	public Candidat() {
		super();

	}
}