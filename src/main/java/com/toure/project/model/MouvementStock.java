package com.toure.project.model;

import java.time.Instant;

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
@Table(name="MouvementStock")
public class MouvementStock extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="article")
	private Article article;
	
	@Column(name="dateMouvement")
	private Instant dateMouvement;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="identreprise")
	private Integer idEntreprise;
	
	@Column(name="typeDeMouvement")
	private TypeMouvement typeMouvement;

}
