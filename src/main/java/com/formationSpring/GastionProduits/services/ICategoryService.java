package com.formationSpring.GastionProduits.services;

import com.formationSpring.GastionProduits.entities.Categorie;
import com.formationSpring.GastionProduits.entities.Produit;

import java.util.List;

public interface ICategoryService {
    public void sauvegarderCategorie(Categorie c);
    public void supprimerCategorie(Long id);
    public List<Categorie> getAllCategorie();
    public Categorie getCategorie(Long id );
    public List<Categorie> CategoriePMC(String mc);

}
