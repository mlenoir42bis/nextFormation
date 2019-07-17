package com.apps.dao;

import java.util.List;

import com.apps.entity.Produit;

public interface IDAOProduit {
	Produit find(Long produitID);
	Produit find(String referenceProduit);
	List<? extends Produit> getAllProduit();
	List<? extends Produit> getAllProduitLazy();
}
