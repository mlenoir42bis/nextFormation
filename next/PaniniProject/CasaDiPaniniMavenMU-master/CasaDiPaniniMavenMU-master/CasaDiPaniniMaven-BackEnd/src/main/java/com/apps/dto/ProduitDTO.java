package com.apps.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apps.entity.model.CategorieProduit;
import com.apps.entity.model.StatutProduit;
import com.apps.entity.model.TypeProduit;

public class ProduitDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6016589213845477452L;
	private Long produitID;
	private String referenceProduit;
	private TypeProduit typeProduit;
	private CategorieProduit categorieProduit;
	private String nomProduit;
	private String nomImageProduit;
	private double prixProduit;
	private StatutProduit statutProduit;
	private List<IngredientDTO> ingredients;
	private List<ProduitDTO> produits;
	
	public ProduitDTO() {
		this.setIngredients(new ArrayList<IngredientDTO>());
		this.setProduits(new ArrayList<ProduitDTO>());
	}
	
	@Override
	public String toString() {
		return "Categorie: "+this.categorieProduit+" type: "+this.typeProduit+" : "+this.nomProduit+" Prix : "+this.prixProduit+" Disponibilit� : "+this.statutProduit;
	}

	public Long getProduitID() {
		return produitID;
	}

	public void setProduitID(Long produitID) {
		this.produitID = produitID;
	}

	public String getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(String referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	public TypeProduit getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNomImageProduit() {
		return nomImageProduit;
	}

	public void setNomImageProduit(String nomImageProduit) {
		this.nomImageProduit = nomImageProduit;
	}

	public StatutProduit getStatutProduit() {
		return statutProduit;
	}

	public void setStatutProduit(StatutProduit statutProduit) {
		this.statutProduit = statutProduit;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public List<ProduitDTO> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitDTO> produits) {
		this.produits = produits;
	}

	public double getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}

}
