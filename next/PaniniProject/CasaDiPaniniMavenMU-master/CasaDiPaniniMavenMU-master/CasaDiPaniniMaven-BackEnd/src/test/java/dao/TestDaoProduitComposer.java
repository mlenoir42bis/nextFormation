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
import com.apps.dao.IDAOProduitComposer;
import com.apps.entity.Ingredient;
import com.apps.entity.ProduitComposer;
import com.apps.entity.model.TypeProduit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDaoProduitComposer {
	
	@Autowired
	IDAOProduitComposer produitComposerDao;
	@Autowired
	IDAOIngredient ingredientDao;
	
	@Test
	@Rollback(true)
	public void ajouterProduit() {
		
		System.out.println("ADD PROD");
		
		ProduitComposer produitComposer = new ProduitComposer();
		produitComposer.setNomProduit("produit à ingredient");
		produitComposer.setTypeProduit(TypeProduit.PANINI);
		
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");
		
		produitComposer.getIngredients().add(ingredient);
		produitComposer.getIngredients().add(ingredient2);
		
		produitComposerDao.save(produitComposer);
		
		System.out.println(produitComposerDao.getAll().size());
		
		Assert.assertEquals(1, produitComposerDao.getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void ajouterProduitIngredientExist() {
		
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		ingredient.setReferenceIngredient("bacon");
		
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");
		ingredient2.setReferenceIngredient("cheese");
		
		ingredientDao.save(ingredient);
		ingredientDao.save(ingredient2);
		
		System.out.println("ADD PROD");
		
		ProduitComposer produitComposer = new ProduitComposer();
		produitComposer.setNomProduit("produit à ingredient");
		produitComposer.setTypeProduit(TypeProduit.PANINI);
		
		produitComposer.getIngredients().add(ingredientDao.find("bacon"));
		produitComposer.getIngredients().add(ingredientDao.find("cheese"));
		
		produitComposerDao.save(produitComposer);
		Assert.assertEquals(1, produitComposerDao.getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void removeProduit() {
		
		System.out.println("Remove PROD");
		
		ProduitComposer produitComposer = new ProduitComposer();
		produitComposer.setNomProduit("produit à ingredient");
		produitComposer.setReferenceProduit("produitB");
		produitComposer.setTypeProduit(TypeProduit.PANINI);
		
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");
		
		produitComposer.getIngredients().add(ingredient);
		produitComposer.getIngredients().add(ingredient2);
		
		produitComposerDao.save(produitComposer);
		
		produitComposer = (ProduitComposer) produitComposerDao.find("produitB");
		produitComposerDao.remove(produitComposer);
		
		Assert.assertEquals(0, produitComposerDao.getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void findProduit() {
		System.out.println("FIND PROD");
		
		ProduitComposer produitComposer = new ProduitComposer();
		produitComposer.setNomProduit("Produit 1");
		produitComposer.setReferenceProduit("produitA");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("salade");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("ham");
		
		produitComposer.getIngredients().add(ingredient);
		produitComposer.getIngredients().add(ingredient2);
		
		produitComposerDao.save(produitComposer);
		
		ProduitComposer produitFinded =  (ProduitComposer) produitComposerDao.find("produitA");
		
		for(Ingredient i : produitFinded.getIngredients())
			System.out.println(i.getNomIngredient());
		
		Assert.assertEquals("Produit 1", produitFinded.getNomProduit());
	}
	
	@Test
	@Rollback(true)
	public void updateProduit() {
		System.out.println("UPDATE PROD");
		
		ProduitComposer produitComposer = new ProduitComposer();
		produitComposer.setNomProduit("produit 1");
		produitComposer.setReferenceProduit("produitB");
		
		produitComposerDao.save(produitComposer);
		
		produitComposer = (ProduitComposer) produitComposerDao.find("produitB");
		produitComposer.setNomProduit("produit 1 modifier");
		
		produitComposerDao.update(produitComposer);
		
		System.out.println(produitComposerDao.find("produitB").getNomProduit());
		Assert.assertEquals("produit 1 modifier", produitComposerDao.find("produitB").getNomProduit());
	}
}
