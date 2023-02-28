package com.formationSpring.GastionProduits.controller;

import com.formationSpring.GastionProduits.entities.Categorie;
import com.formationSpring.GastionProduits.entities.Produit;
import com.formationSpring.GastionProduits.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CategorieController")
public class CategorieController {
    @Autowired
    ICategoryService iCategoryService;


    @GetMapping("/all")
    public String getAllCategories(Model m) {
        List<Categorie> ll= iCategoryService.getAllCategorie();
        m.addAttribute("Categories", ll);
        return "listCategorie";
    }




    @GetMapping ("/delete/{id}")
    public String  supprimerCat(@PathVariable Long id ){
        iCategoryService.supprimerCategorie(id);
        return "redirect:/CategorieController/all";
    }


    @GetMapping("/ajouter")
    public String ajout(Model m){

        return "AjoutCat";
    }

    @PostMapping("/save")
    public String sauvgarer(@ModelAttribute Categorie c) {

        iCategoryService.sauvegarderCategorie(c);

        return "redirect:/CategorieController/all";
    }

    @GetMapping("/update/{id}")
    public String  matreajour(Model m,@PathVariable Long id){
        Categorie c;
        c=iCategoryService.getCategorie(id);
        List<Categorie> liste= new ArrayList<>();
        liste.add(c);
        m.addAttribute("catego",liste);

        return "updateCat";

    }


    @GetMapping("/search")
    public String rechecher(Model m ,@RequestParam String mc){
        List<Categorie>ll= iCategoryService.CategoriePMC(mc);

        m.addAttribute("Categories", ll);
        return "listCategorie";
    }


}
