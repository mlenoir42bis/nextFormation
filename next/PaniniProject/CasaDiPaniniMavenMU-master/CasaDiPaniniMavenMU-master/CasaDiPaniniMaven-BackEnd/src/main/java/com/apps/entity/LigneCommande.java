package com.apps.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LigneCommande implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1749143873599780515L;
	
	@Id
	@GeneratedValue
	private Long ligneCommandeID;
	@OneToOne
	private Produit produit;
	private int quantite;
	@ManyToOne
	private Commande commande;
	
	public LigneCommande() {
		
	}
	
	@Override
	public String toString() {
		return "Produit : "+this.produit.getNomProduit()+" Quantit� : "+this.quantite;
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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
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
