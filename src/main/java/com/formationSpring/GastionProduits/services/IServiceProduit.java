package com.formationSpring.GastionProduits.services;

import java.util.List;

import com.formationSpring.GastionProduits.entities.Produit;

public interface IServiceProduit {
	public void Sauvgarder(Produit p);
	public List<Produit> getAllProducts();
	public List<Produit> getProductsBMC(String mc);
	public Produit getProduct(Long id);
	public void deleteProduct(Long id);

}
