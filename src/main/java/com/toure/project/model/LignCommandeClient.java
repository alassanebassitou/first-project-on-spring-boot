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
@Table(name="LignCommandeClient")
public class LignCommandeClient extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="idArticleCommande")
	private Article articleCommande;
	
	@Column(name="quantiteCommande")
	private Integer quantiteCommande;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name="idCommandeClient")
	private CommandeClient commandeClient;

}
