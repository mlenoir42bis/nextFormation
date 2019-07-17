package com.apps.model;

import java.io.Serializable;
import java.util.List;

public class Panier implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5327044627908112188L;
	private List<LignePanier> lignePaniers;
	
	public Panier() {
		
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(LignePanier lp : this.lignePaniers)
			stringBuilder.append("Produit : "+lp.getProduit().getNomProduit()+" Quantité : "+lp.getQuantite());
		return stringBuilder.toString();
	}

	public void add(LignePanier lignePanier) {
		this.lignePaniers.add(lignePanier);
	}
	
	public void remove(LignePanier lignePanier) {
		this.lignePaniers.remove(lignePanier);
	}
	
	public LignePanier get(int lignePanierID) {
		return this.lignePaniers.get(lignePanierID);
	}

	//Getter Setter
	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}

	public void setLignePaniers(List<LignePanier> lignePaniers) {
		this.lignePaniers = lignePaniers;
	}
}
