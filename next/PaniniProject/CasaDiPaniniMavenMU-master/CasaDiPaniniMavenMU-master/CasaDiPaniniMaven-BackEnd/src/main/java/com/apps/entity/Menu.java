package com.apps.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Menu extends Produit {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 604548651610003728L;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<ProduitComposer> produits;
	
	public Menu() {
		this.setProduits(new ArrayList<ProduitComposer>());
	}

	public List<ProduitComposer> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitComposer> produits) {
		this.produits = produits;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
