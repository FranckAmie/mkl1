package com.mtl.mokolo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ColisEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double poids;
	private Double prix;
	private String descriptif;
	private Boolean estEnveloppe;
	public Long getId() {
		return id;
	}
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public Boolean getEstEnveloppe() {
		return estEnveloppe;
	}
	public void setEstEnveloppe(Boolean estEnveloppe) {
		this.estEnveloppe = estEnveloppe;
	}
	public ColisEntity() {
		super();
	}
	public ColisEntity(Long id, Double poids, Double prix, String descriptif, Boolean estEnveloppe) {
		super();
		this.id = id;
		this.poids = poids;
		this.prix = prix;
		this.descriptif = descriptif;
		this.estEnveloppe = estEnveloppe;
	}
	

}
