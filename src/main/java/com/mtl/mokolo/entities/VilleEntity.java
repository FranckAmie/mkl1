package com.mtl.mokolo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VilleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codeVille;
	private String nomVille;
	private String nomPays;
	private String codePays;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getCodeVille() {
		return codeVille;
	}
	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	public VilleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VilleEntity(Long id, String codeVille, String nomVille, String nomPays, String codePays) {
		super();
		this.id = id;
		this.codeVille = codeVille;
		this.nomVille = nomVille;
		this.nomPays = nomPays;
		this.codePays = codePays;
	}
	
}
