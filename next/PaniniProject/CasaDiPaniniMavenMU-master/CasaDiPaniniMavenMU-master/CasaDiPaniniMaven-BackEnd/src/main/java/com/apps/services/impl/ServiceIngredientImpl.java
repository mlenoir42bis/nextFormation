package com.apps.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOIngredient;
import com.apps.dto.IngredientDTO;
import com.apps.entity.Ingredient;
import com.apps.services.IServiceIngredient;

@Transactional
@Service
public class ServiceIngredientImpl implements IServiceIngredient {
	
	@Autowired
    private IDAOIngredient ingredientDao;
	@Autowired
	private Mapper mapper;
	
    private static final Logger logger = Logger.getLogger(ServiceClientImpl.class);

    @Override
	public void save(IngredientDTO ingredientDTO) {
		logger.info("donne un ingredient au dao a sauver");
		this.ingredientDao.save(this.mapper.map(ingredientDTO, Ingredient.class));
	}
	
    @Override
	public IngredientDTO get(Long ingredientID) {
		logger.info("retourne un ingredient demand� au dao");
		return this.mapper.map(this.ingredientDao.find(ingredientID), IngredientDTO.class);
	}
    
    @Override
   	public IngredientDTO get(String referenceIngredient) {
   		logger.info("retourne un ingredient demand� au dao");
   		return  this.mapper.map(this.ingredientDao.find(referenceIngredient), IngredientDTO.class);
   	}
	
    @Override
	public List<IngredientDTO> getAll() {
		logger.info("retourne une liste d ingredient demande au dao");
		List<IngredientDTO> ingredientDTOs = new ArrayList<IngredientDTO>();
		for(Ingredient ingredient : this.ingredientDao.getAll()) {
			ingredientDTOs.add(this.mapper.map(ingredient, IngredientDTO.class));
		}
		return ingredientDTOs;
	}
	
    @Override
	public void update(IngredientDTO ingredientDTO) {
		logger.info("updtae un ingredient donne au dao");
		this.ingredientDao.update(this.mapper.map(ingredientDTO, Ingredient.class));
	}
	
    @Override
	public void remove(IngredientDTO ingredientDTO) {
		logger.info("demmande a dao de supprimer un ingredient");
		this.ingredientDao.remove(this.mapper.map(ingredientDTO, Ingredient.class));
	}
}
