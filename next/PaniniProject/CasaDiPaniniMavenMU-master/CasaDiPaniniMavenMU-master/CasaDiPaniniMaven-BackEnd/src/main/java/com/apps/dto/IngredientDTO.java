package com.apps.dto;

import java.io.Serializable;

import com.apps.entity.model.StatutIngredient;

public class IngredientDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4217639044150949235L;
	private Long ingredientID;
	private String referenceIngredient;
	private String nomIngredient;
	private String descriptionIngredient;
	private String nomImageIngredient;
	private StatutIngredient statutIngredient;
	
	public IngredientDTO() {
		
	}
	
	@Override
	public String toString() {
		return "ingredient : "+this.nomIngredient+": "+this.descriptionIngredient+" disponibilite : "+this.statutIngredient+" ref : "+this.referenceIngredient;
	}

	public Long getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(Long ingredientID) {
		this.ingredientID = ingredientID;
	}

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public String getDescriptionIngredient() {
		return descriptionIngredient;
	}

	public void setDescriptionIngredient(String descriptionIngredient) {
		this.descriptionIngredient = descriptionIngredient;
	}

	public StatutIngredient getStatutIngredient() {
		return statutIngredient;
	}

	public void setStatutIngredient(StatutIngredient statutIngredient) {
		this.statutIngredient = statutIngredient;
	}

	public String getReferenceIngredient() {
		return referenceIngredient;
	}

	public void setReferenceIngredient(String referenceIngredient) {
		this.referenceIngredient = referenceIngredient;
	}

	public String getNomImageIngredient() {
		return nomImageIngredient;
	}

	public void setNomImageIngredient(String nomImageIngredient) {
		this.nomImageIngredient = nomImageIngredient;
	}
}
