package com.toure.project.model;

import java.math.BigDecimal;
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
@Table(name="article")
public class Article extends AbstractEntity {
	
	@Column(name="code_art")
	private String code;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="prixht")
	private BigDecimal prixHT;
	
	@Column(name="tauxtva")
	private BigDecimal tauxTVA;
	
	@Column(name="prixtt")
	private BigDecimal prixTTC;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="identreprise")
	private Integer idEntreprise;

	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category;
	
	@OneToMany(mappedBy="article_commande")
	private List<LignCommandeClient> lignCommandeClient;
	
	@OneToMany(mappedBy="article_fournis")
	private List<LignCommandeFournisseur> lignCommandeFournisseur;
	
	@OneToMany(mappedBy="article_vendu")
	private List<LigneVente> ligneVente;
	
	@OneToMany(mappedBy="article")
	private List<MouvementStock> mouvementStock;
	

}
