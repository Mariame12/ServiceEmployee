package com.service.entities;

import jakarta.persistence.CascadeType;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="employee")

public  class Employee {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Fonction fonction ;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nom", referencedColumnName = "id")
	
	private Personne personne;

	public Employee(Long id, Fonction fonction, Personne personne) {
		super();
		this.id = id;
		this.fonction = fonction;
		this.personne = personne;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fonction=" + fonction + ", personne=" + personne + "]";
	}
	
	
	
	
	

}
