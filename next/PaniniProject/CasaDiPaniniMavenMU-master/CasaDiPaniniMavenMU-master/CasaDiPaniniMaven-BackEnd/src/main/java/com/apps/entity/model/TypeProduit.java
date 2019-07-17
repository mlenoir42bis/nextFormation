package com.apps.entity.model;

public enum TypeProduit {
	PANINI("Panini"),
	PANINI_PERSO("Panini personalisé"),
	SALADE("Salade"),
	HOT_DOG("Hot dog"),
	BOISSON("Boisson sans sucre"),
	MENU("formule du jour");
	
	private String typeProduit;
	
	private TypeProduit(String typeProduit) {
		this.setTypeProduit(typeProduit);
	}

	public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}
}
