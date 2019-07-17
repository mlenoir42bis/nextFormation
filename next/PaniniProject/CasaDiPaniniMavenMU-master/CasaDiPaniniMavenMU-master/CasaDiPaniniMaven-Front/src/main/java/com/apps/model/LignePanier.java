package com.apps.model;

import java.io.Serializable;

import com.apps.dto.ProduitDTO;

public class LignePanier implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8799986057297813589L;

	private ProduitDTO produit;
	private int quantite;
	
	public LignePanier() {

	}
	
	@Override
	public String toString() {
		return "Produit : "+this.produit.getNomProduit()+" Quantit� : "+this.quantite;
	}

	public ProduitDTO getProduit() {
		return produit;
	}

	public void setProduit(ProduitDTO produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
