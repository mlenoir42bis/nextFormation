package com.apps.services;

import java.util.List;

import com.apps.dto.IngredientDTO;


public interface IServiceIngredient {
	void save(IngredientDTO ingredientDTO);
	IngredientDTO get(Long ingredientID);
    List<IngredientDTO> getAll();
    void update(IngredientDTO ingredientDTO);
	void remove(IngredientDTO ingredientDTO);
	IngredientDTO get(String referenceIngredient);
}
