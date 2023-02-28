package com.formationSpring.GastionProduits.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;

	//@OneToMany (mappedBy = "cat" , cascade=CascadeType.ALL)
	//@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	@OneToMany (mappedBy = "cat",cascade=CascadeType.ALL)

	List<Produit>liste;


}
