package com.toure.project.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="commandeFournisseur")
public class CommandeFournisseur extends AbstractEntity {
	
	@Column(name="codeCom")
	private String codeCom;
	
	@Column(name="dateCommande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idfournisseur")
	private Fournisseur fournisseur;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@OneToMany(mappedBy="commandeFournisseur")
	private List<LignCommandeFournisseur> lignCommandefournisseur;

}
