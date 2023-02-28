package com.formationSpring.GastionProduits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formationSpring.GastionProduits.entities.Categorie;

import java.util.List;

@Repository
public interface cathegoryRepository extends JpaRepository<Categorie, Long> {
    @Query("select c from Categorie c where c.nom like %:x%")
    public List<Categorie> getCategorieByMC(@Param("x") String mc);
}
