package com.formationSpring.GastionProduits.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
    private String nom;
    private double prix;
    private int quantite;
    @ManyToOne
    Categorie cat;


}
