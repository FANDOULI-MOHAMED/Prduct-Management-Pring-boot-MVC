package com.formationSpring.GastionProduits.services;

import java.util.List;

import com.formationSpring.GastionProduits.repositories.cathegoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formationSpring.GastionProduits.entities.Produit;
import com.formationSpring.GastionProduits.repositories.produitRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ProductService implements IServiceProduit {

	produitRepository pr;
	//cathegoryRepository cr;
	
	
	@Override
	public void Sauvgarder(Produit p) {
		pr.save(p);
		
	}

	@Override
	public List<Produit> getAllProducts() {
		
		return pr.findAll();
	}

	@Override
	public List<Produit> getProductsBMC(String mc) {
		// TODO Auto-generated method stub
		return pr.getProductsBMC(mc);
	}

	@Override
	public Produit getProduct(Long id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

}

