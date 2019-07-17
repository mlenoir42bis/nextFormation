package com.apps.dao;

import java.util.List;

import com.apps.entity.Commande;

public interface IDAOCommande {
	void save(Commande commande);
	Commande find(Long commandeID);
    List<Commande> getAll();
	void update(Commande commande);
	void remove(Commande commande);
	Commande find(String reference);
	List<Commande> getAllLazy();
}
