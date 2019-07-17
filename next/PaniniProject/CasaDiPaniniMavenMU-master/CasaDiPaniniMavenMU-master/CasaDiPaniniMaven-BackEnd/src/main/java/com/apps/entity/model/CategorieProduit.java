package com.apps.entity.model;

public enum CategorieProduit {
	PRODUIT_COMPOSER("produit composer"),
	MENU("menu");
	
	private String categorieProduit;
	
	private CategorieProduit(String categorieProduit) {
		this.setCategorieProduit(categorieProduit);
	}

	public String getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(String categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

}
