package com.formationSpring.GastionProduits.controller;

import com.formationSpring.GastionProduits.entities.Categorie;
import com.formationSpring.GastionProduits.services.ICategoryService;
import com.formationSpring.GastionProduits.services.IServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.formationSpring.GastionProduits.entities.Produit;
import com.formationSpring.GastionProduits.services.ProductService;

@Controller
@RequestMapping("/ProductController")
public class ProductController   {
	
	@Autowired
	IServiceProduit iServiceProduit;
	@Autowired
	ICategoryService iCategoryService;

	@GetMapping("/all")

	public String getAllProducts(Model m) {
		List<Produit>ll= iServiceProduit.getAllProducts();
		m.addAttribute("produits", ll);	
		return "listProduits";
	}




	/*  @PostMapping("/AddProduct")
    public String AddProduct(@PathVariable String nom, double prix, int quantite){


    }*/
	@GetMapping ("/delete/{id}")
	public String  supprimerProduit(@PathVariable  Long id ){
		iServiceProduit.deleteProduct(id);
		return "redirect:/ProductController/all";
	}


	@GetMapping("/ajouter")
	public String ajout(Model m){
	m.addAttribute("categories",iCategoryService.getAllCategorie());
	return "add";
	}

	@PostMapping("/save")
	public String sauvgarer(@ModelAttribute  Produit p) {

		iServiceProduit.Sauvgarder(p);
		System.out.println(p.getCat().getNom());
		return "redirect:/ProductController/all";
	}
	Produit p;
	@GetMapping("/update/{id}")
	public String  matreajour(Model m,@PathVariable Long id){

		p=iServiceProduit.getProduct(id);
		List<Produit> liste= new ArrayList<>();
		liste.add(p);
		m.addAttribute("prod",liste);
		m.addAttribute("categories",iCategoryService.getAllCategorie());
		return "update";

	}


	@GetMapping("/search")
		public String rechecher(Model m ,@RequestParam String mc){
		List<Produit>ll= iServiceProduit.getProductsBMC(mc);

		m.addAttribute("produits", ll);
		return "listProduits";
		}






}
