package com.formationSpring.GastionProduits.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.formationSpring.GastionProduits.entities.Produit;

@Repository
public interface produitRepository extends JpaRepository<Produit, Long> {
	
	
	@Query("select p from Produit p where p.nom like %:x%")
	public List<Produit> getProductsBMC(@org.springframework.data.repository.query.Param ("x")String mot );
	

}
