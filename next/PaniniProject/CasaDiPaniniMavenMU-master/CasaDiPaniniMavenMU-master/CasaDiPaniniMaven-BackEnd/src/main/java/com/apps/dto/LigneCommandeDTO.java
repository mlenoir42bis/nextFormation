package com.apps.dto;

import java.io.Serializable;

import com.apps.entity.Produit;

public class LigneCommandeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3256007755852324925L;
	
	private Long ligneCommandeID;
	private Produit produit;
	private int quantite;
	private CommandeDTO commande;
	
	public LigneCommandeDTO() {
		
	}
	
	@Override
	public String toString() {
		return "Produit : "+this.produit.getNomProduit()+" Quantit� : "+this.quantite;
	}

	public CommandeDTO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDTO commandeDTO) {
		this.commande = commandeDTO;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Long getLigneCommandeID() {
		return ligneCommandeID;
	}

	public void setLigneCommandeID(Long ligneCommandeID) {
		this.ligneCommandeID = ligneCommandeID;
	}

}
