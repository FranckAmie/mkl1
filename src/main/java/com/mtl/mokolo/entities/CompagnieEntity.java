package com.mtl.mokolo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompagnieEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String code;
	private String nom;
	private String refVol;
	public Long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRefVol() {
		return refVol;
	}
	public void setRefVol(String refVol) {
		this.refVol = refVol;
	}
	public CompagnieEntity(Long id, String code, String nom, String refVol) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.refVol = refVol;
	}
	public CompagnieEntity() {
		super();
	}
	
}
