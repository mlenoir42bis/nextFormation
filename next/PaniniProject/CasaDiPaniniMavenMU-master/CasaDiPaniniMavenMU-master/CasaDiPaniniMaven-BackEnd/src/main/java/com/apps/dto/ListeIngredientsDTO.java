package com.apps.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListeIngredientsDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -794696655215706251L;
	private List<IngredientDTO> ingredientsDTO;
	
	public ListeIngredientsDTO() {
		this.setIngredientsDTO(new ArrayList<IngredientDTO>());
	}
	
	public void add(IngredientDTO ingredientDTO) {
		this.ingredientsDTO.add(ingredientDTO);
	}
	
	public void clear() {
		this.ingredientsDTO.clear();
	}
	
	public IngredientDTO get(int ingredientID) {
		return this.ingredientsDTO.get(ingredientID);
	}

	public List<IngredientDTO> getIngredientsDTO() {
		return ingredientsDTO;
	}

	public void setIngredientsDTO(List<IngredientDTO> ingredientsDTO) {
		this.ingredientsDTO = ingredientsDTO;
	}
}
