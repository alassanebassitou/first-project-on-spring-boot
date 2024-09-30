package com.toure.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="Entreprise")
public class Entreprise extends AbstractEntity {
	
	@Column(name="nomEntreprise")
	private String name;
	
	@Column(name="adresseEntrprise")
	private Adresse Adress;
	
	@Column(name="description")
	private String description;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="codeFiscal")
	private String codeFiscal;
	
	@Column(name="webSite")
	private String webSite;
	
	@OneToMany(mappedBy="entreprise")
	private List<Utilisateur> utilisateur;

}
