package com.formationSpring.GastionProduits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.formationSpring.GastionProduits.controller.ProductController;
import java.io.File;

@SpringBootApplication
public class GastionProduitsApplication {

	public static void main(String[] args) {
		new File(ProductController.uploadDirectory).mkdir();
		SpringApplication.run(GastionProduitsApplication.class, args);
	}

}
