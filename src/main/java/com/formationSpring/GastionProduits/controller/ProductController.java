package com.formationSpring.GastionProduits.controller;


import com.formationSpring.GastionProduits.services.ICategoryService;
import com.formationSpring.GastionProduits.services.IServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.formationSpring.GastionProduits.entities.Produit;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ProductController")
public class ProductController   {


	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	
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
	public String sauvgarer(@ModelAttribute  Produit p, @RequestParam("files") MultipartFile[] files) {

		/// part upload

		StringBuilder fileName = new StringBuilder();
		MultipartFile file = files[0];
		Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

		fileName.append(file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		p.setPicture(fileName.toString());



		iServiceProduit.Sauvgarder(p);
		System.out.println(p.getCat().getNom());
		return "redirect:/ProductController/all";
	}
	//***************************
	@PostMapping("/saveup")
	public String sauvgarerr(@ModelAttribute  Produit p) {

		iServiceProduit.Sauvgarder(p);
		System.out.println(p.getCat().getNom());
		return "redirect:/ProductController/all";
	}
	//***************************
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
