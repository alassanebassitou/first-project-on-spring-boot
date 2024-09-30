package com.toure.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name="Client")
public class Client extends AbstractEntity {
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="num_tel")
	private Integer numTel;
	
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@OneToMany(mappedBy="client")
	private List<CommandeClient> commandeClient;

}
