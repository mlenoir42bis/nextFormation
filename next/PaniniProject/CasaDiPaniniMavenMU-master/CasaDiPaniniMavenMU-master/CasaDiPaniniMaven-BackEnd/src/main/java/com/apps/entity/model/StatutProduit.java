package com.apps.entity.model;

public enum StatutProduit {
	BIENTOT_DISPONIBLE("Bientôt disponible"),
	DISPONIBLE("Disponible"),
	INDISPONIBLE("Non disponible");
	
	private String statutProduit;
	
	private StatutProduit(String statutProduit) {
		this.setStatutProduit(statutProduit);
	}

	public String getStatutProduit() {
		return statutProduit;
	}

	public void setStatutProduit(String statutProduit) {
		this.statutProduit = statutProduit;
	}
}
