package com.apps.dao;

import java.util.List;

import com.apps.entity.Ingredient;

public interface IDAOIngredient {
	void save(Ingredient ingredient);
	Ingredient find(Long ingredientID);
    List<Ingredient> getAll();
	void update(Ingredient ingredient);
	void remove(Ingredient ingredient);
	Ingredient find(String referenceIngredient);
}
