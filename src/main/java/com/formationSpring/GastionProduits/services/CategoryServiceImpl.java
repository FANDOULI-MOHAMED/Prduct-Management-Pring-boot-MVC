package com.formationSpring.GastionProduits.services;

import com.formationSpring.GastionProduits.entities.Categorie;
import com.formationSpring.GastionProduits.repositories.cathegoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements  ICategoryService {
    cathegoryRepository cr;



    @Override
    public void sauvegarderCategorie(Categorie c) {
        // TODO Auto-generated method stub
        cr.save(c);

    }


    public void supprimerCategorie(Long id) {
        // TODO Auto-generated method stub
        cr.deleteById(id);

    }

    @Override
    public List<Categorie> getAllCategorie() {
        // TODO Auto-generated method stub
        return cr.findAll();
    }




    public Categorie getCategorie(Long id) {
        // TODO Auto-generated method stub
        return cr.findById(id).get();
    }

    @Override
    public List<Categorie> CategoriePMC(String mc) {
        // TODO Auto-generated method stub
        return cr.getCategorieByMC(mc);
    }
}
