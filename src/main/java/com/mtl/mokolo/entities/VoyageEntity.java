package com.mtl.mokolo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VoyageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private VilleEntity villeDepart;
	@ManyToOne
	private VilleEntity villeArrivee;
	private String heureDepart;
	private String heureArrivee;
	@ManyToOne
	private UserEntity person;
	
	public Long getId() {
		return id;
	}
	
	public VilleEntity getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(VilleEntity villeDepart) {
		this.villeDepart = villeDepart;
	}
	public VilleEntity getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(VilleEntity villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public UserEntity getPerson() {
		return person;
	}
	public void setPerson(UserEntity person) {
		this.person = person;
	}
	public VoyageEntity(Long id, VilleEntity villeDepart, VilleEntity villeArrivee, String heureDepart, String heureArrivee,
			UserEntity person) {
		super();
		this.id = id;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.person = person;
	}
	public VoyageEntity() {
		super();
	}
	
	
	
}
