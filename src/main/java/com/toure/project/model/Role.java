package com.toure.project.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="Role")
public class Role extends AbstractEntity {
	
	@Column(name="rolename")
	private String rolename;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Utilisateur> utilisateur;

}
