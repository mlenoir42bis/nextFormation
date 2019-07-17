package com.apps.services;

import java.util.List;

import com.apps.dto.ProduitDTO;

public interface IServiceProduit {
	void save(ProduitDTO produitDTO);
	ProduitDTO getProduitByID(Long produitID);
	ProduitDTO getProduitByRef(String referenceProduit);
    List<ProduitDTO> getAllProduit();
    List<ProduitDTO> getAllProduitLazy();
    void update(ProduitDTO produitDTO);
	void remove(ProduitDTO produitDTO);
	List<ProduitDTO> getAllMenu();
	List<ProduitDTO> getAllProduitComposer();
}