package com.apps.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ProduitComposer extends Produit {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 604548651610003728L;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Ingredient> ingredients;
	
	public ProduitComposer() {
		this.setIngredients(new ArrayList<Ingredient>());
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
