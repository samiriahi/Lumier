package com.supportportal.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    private String nomPrenom;
    private String departement;
    private String fonction;
    private String site;
    private String tel;
    private String mat;

    @ManyToMany(cascade = CascadeType.ALL) // ManyToMany relationship with Employee
    @JoinTable(name = "stagier_employee", // Join table for the relationship
        joinColumns = @JoinColumn(name = "idStagier"),
        inverseJoinColumns = @JoinColumn(name = "idEmployee"))
    private Set<Employee> contacts;
    
    
    
    @JsonBackReference
    @ManyToMany(mappedBy = "participants")
    private List<Formation> formations;
    
    
    
    
    public Employee() {
    	super();
    }
    
   

    public Employee(String nomPrenom, String departement, String fonction, String site, String tel, String mat) {
        this.nomPrenom = nomPrenom;
        this.departement = departement;
        this.fonction = fonction;
        this.site = site;
        this.tel = tel;
        this.mat = mat;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
}
