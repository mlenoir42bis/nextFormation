package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOIngredient;
import com.apps.entity.Ingredient;
import com.apps.entity.model.StatutIngredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDaoIngredient {
	
	@Autowired
	IDAOIngredient ingredientDao;
	
	@Test
	@Rollback(true)
	public void ajouterIngredient() {
		
		System.out.println("ADD Ingredient");
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		ingredient.setDescriptionIngredient("Bacon americain");
		ingredient.setStatutIngredient(StatutIngredient.DISPONIBLE);
		ingredient.setReferenceIngredient("bacon");
		
		ingredientDao.save(ingredient);
		Assert.assertEquals(1, ingredientDao.getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void findIngredient() {
		System.out.println("FIND Ingredient");
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		ingredient.setDescriptionIngredient("Bacon americain");
		ingredient.setStatutIngredient(StatutIngredient.DISPONIBLE);
		ingredient.setReferenceIngredient("bacon");
		ingredientDao.save(ingredient);
		
		Ingredient ingredientToFind = ingredientDao.find("bacon");
		Assert.assertEquals("Bacon americain", ingredientToFind.getDescriptionIngredient());
	}
	
	@Test
	@Rollback(true)
	public void updateIngredient() {
		System.out.println("UPDATE Ingredient");
		System.out.println("FIND Ingredient");
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		ingredient.setDescriptionIngredient("Bacon americain");
		ingredient.setStatutIngredient(StatutIngredient.DISPONIBLE);
		ingredient.setReferenceIngredient("bacon");
		ingredientDao.save(ingredient);
		
		ingredient = ingredientDao.find("bacon");
		ingredient.setDescriptionIngredient("Bacon canadien");
		ingredientDao.update(ingredient);
		
		Ingredient ingredientToFind = ingredientDao.find("bacon");
		Assert.assertEquals("Bacon canadien", ingredientToFind.getDescriptionIngredient());
	}
	
	@Test
	@Rollback(true)
	public void getAllIngredient() {
		System.out.println("Get all Ingredient");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setReferenceIngredient("bacon");
		ingredientDao.save(ingredient);
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setReferenceIngredient("bacon2");
		ingredientDao.save(ingredient2);
		
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setReferenceIngredient("bacon3");
		ingredientDao.save(ingredient3);
		
		for(Ingredient ingredientList : ingredientDao.getAll()) {
			System.out.println(ingredientList.getReferenceIngredient());
			Assert.assertNotNull(ingredientList);
		}
	}
	
	@Test
	@Rollback(true)
	public void removeIngredient() {
		System.out.println("Get all Ingredient");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setReferenceIngredient("bacon");
		ingredientDao.save(ingredient);
		
		ingredient = ingredientDao.find("bacon");
		ingredientDao.remove(ingredient);
		Assert.assertEquals(0, ingredientDao.getAll().size());
	}
}
