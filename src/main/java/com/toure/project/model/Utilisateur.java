package com.toure.project.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="Utilisateur")
public class Utilisateur extends AbstractEntity {
	
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
	
	@Column(name="mot_de_passe")
	private String motPass;
	
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	
	@Column(name="photo")
	private String photo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "Utilisateur_roles_Mapping", joinColumns= @JoinColumn(name="utilisateur_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	private Entreprise entreprise;

}
