package com.formationSpring.GastionProduits.controller;

import com.formationSpring.GastionProduits.entities.Produit;
import com.formationSpring.GastionProduits.services.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ApiProduct")
@AllArgsConstructor
public class ProductRestController {
    private IServiceProduit iServiceProduit;

    @GetMapping("/all")
    List<Produit> getAllProduct(){
        return iServiceProduit.getAllProducts();
    }
    @GetMapping("/byMc/{mc}")
    public List<Produit>getProductsBMC(@PathVariable String mc)
    {

        return iServiceProduit.getProductsBMC(mc);
    }
    @PostMapping("/save")
    public void ajouter(@RequestBody Produit p)
    {
        iServiceProduit.Sauvgarder(p);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id){
        iServiceProduit.deleteProduct(id);
    }
    @PutMapping("/modif")
    public  void modifier(@RequestBody Produit p){
        ajouter(p);
    }


}
