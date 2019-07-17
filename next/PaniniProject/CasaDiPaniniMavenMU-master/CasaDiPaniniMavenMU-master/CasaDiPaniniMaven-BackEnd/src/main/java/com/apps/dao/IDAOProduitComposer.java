package com.apps.dao;

import java.util.List;

import com.apps.entity.ProduitComposer;

public interface IDAOProduitComposer {
	
	void save(ProduitComposer produitComposer);
	ProduitComposer find(Long produitComposer);
	ProduitComposer find(String referenceProduitComposer);
	void update(ProduitComposer produitComposer);
	void remove(ProduitComposer produitComposer);
	
	List<ProduitComposer> getAll();
	List<ProduitComposer> getAllLazy();
}
