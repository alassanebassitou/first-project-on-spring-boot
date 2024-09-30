package com.toure.project.model;

import java.time.Instant;
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
@Table(name="Vente")
public class Vente extends AbstractEntity {
	
	@Column(name="codeVente")
	private String codeVent;
	
	@Column(name="dateVente")
	private Instant dateVent;
	
	@Column(name="commentaire")
	private String commentaire;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@OneToMany(mappedBy="vente")
	private List<LigneVente> lignVente;

}
