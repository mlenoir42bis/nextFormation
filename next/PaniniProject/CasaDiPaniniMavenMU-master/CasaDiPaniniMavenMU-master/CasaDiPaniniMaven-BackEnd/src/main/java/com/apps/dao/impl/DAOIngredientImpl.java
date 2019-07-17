package com.apps.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOIngredient;
import com.apps.entity.Ingredient;

@Transactional
@Service
public class DAOIngredientImpl implements IDAOIngredient {
	
	private static final Logger	logger	= Logger.getLogger(DAOIngredientImpl.class);
	
	protected EntityManager		em;
	
	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void save(Ingredient ingredient) {
		logger.info("save un ingredient");
		this.em.persist(ingredient);
	}
	
	@Override
	public Ingredient find(Long ingredientID) {
		logger.info("find un ingredient");
		return this.em.find(Ingredient.class, ingredientID);
	}
	
	@Override
	public Ingredient find(String referenceIngredient) {
		logger.info("find ingredient by ref");
		TypedQuery<Ingredient> queryIngredientByReference =  em.createNamedQuery("Ingredient.findByReferenceIngredient", Ingredient.class);
		queryIngredientByReference.setParameter("referenceIngredient", referenceIngredient);
		return (Ingredient) queryIngredientByReference.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ingredient> getAll() {
		logger.info("recupere la liste des ingredients");
		Query q = this.em.createQuery("FROM Ingredient");
		return (List<Ingredient>) q.getResultList();
	}
	
	@Override
	public void update(Ingredient ingredient) {
		logger.info("update un ingredient");
		this.em.merge(ingredient);
	}
	
	@Override
	public void remove(Ingredient ingredient) {
		logger.info("supprime un ingredient");
		Ingredient ingredientToUpdate = this.em.merge(ingredient);
		this.em.remove(ingredientToUpdate);
	}
	
}
