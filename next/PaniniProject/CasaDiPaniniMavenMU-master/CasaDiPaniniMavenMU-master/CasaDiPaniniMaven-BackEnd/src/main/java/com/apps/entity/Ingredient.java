package com.apps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.apps.entity.model.StatutIngredient;

@Entity
@NamedQuery(name="Ingredient.findByReferenceIngredient", query="SELECT i FROM Ingredient i WHERE i.referenceIngredient = :referenceIngredient")
public class Ingredient {
	
	@Id
	@GeneratedValue
	private Long ingredientID;
	@Column(nullable=true, length=50)
	private String nomIngredient;
	@Column(nullable=true, length=25)
	private String referenceIngredient;
	@Column(nullable=true, length=25)
	private String nomImageIngredient;
	@Column(nullable=true, length=100)
	private String descriptionIngredient;
	@Column(nullable=true, length=10)
	private StatutIngredient statutIngredient;
	
	public Ingredient() {
		
	}
	
	@Override
	public String toString() {
		return "ingredient : "+this.nomIngredient+": "+this.descriptionIngredient+" disponibilite : "+this.statutIngredient+" ref : "+this.referenceIngredient;
	}
	
	public String getNomIngredient() {
		return nomIngredient;
	}

	public Long getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(Long ingredientID) {
		this.ingredientID = ingredientID;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public StatutIngredient getStatutIngredient() {
		return statutIngredient;
	}

	public void setStatutIngredient(StatutIngredient statutIngredient) {
		this.statutIngredient = statutIngredient;
	}

	public String getDescriptionIngredient() {
		return descriptionIngredient;
	}

	public void setDescriptionIngredient(String descriptionIngredient) {
		this.descriptionIngredient = descriptionIngredient;
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
