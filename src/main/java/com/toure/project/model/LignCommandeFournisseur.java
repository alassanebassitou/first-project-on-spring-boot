package com.toure.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name="LignCommandeFournisseur")
public class LignCommandeFournisseur extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="idArticleFournis")
	private Article articleFournis;
	
	@Column(name="quantiteCommande")
	private Integer quantiteFournisseur;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name="idCommandefournisseur")
	private CommandeFournisseur commandeFournisseur;

}
