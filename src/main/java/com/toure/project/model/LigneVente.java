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
@Table(name="LigneVente")
public class LigneVente extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="articleVendu")
	private Article articleVendu;
	
	@Column(name="quantiteVendu")
	private Integer quantiteVendu;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name="idVende")
	private Vente vente;

}
