package dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dto.IngredientDTO;
import com.apps.dto.ProduitDTO;
import com.apps.entity.model.CategorieProduit;
import com.apps.facade.IFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDtoProduit {

	@Autowired
	IFacade	facade;
	
	@Test
	@Rollback(true)
	public void findProduit() {
		ProduitDTO produit = new ProduitDTO();
		produit.setReferenceProduit("prod01");
		produit.setNomProduit("panini 1");
		produit.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
		
		facade.getServiceProduit().save(produit);
		
		Long id = null;
		for(ProduitDTO produitDTO : facade.getServiceProduit().getAllProduit()) {
			id = produitDTO.getProduitID();
		}
		
		ProduitDTO p = facade.getServiceProduit().getProduitByID(id);
		Assert.assertEquals("panini 1", p.getNomProduit());
	}
	
	@Test
	@Rollback(true)
	public void ajoutProduit() {
		ProduitDTO produit = new ProduitDTO();
		produit.setReferenceProduit("prod01");
		produit.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
		
		facade.getServiceProduit().save(produit);
		
		Assert.assertEquals(1, this.facade.getServiceProduit().getAllProduit().size());
	}
	
	@Test
	@Rollback(true)
	public void update() {
		ProduitDTO produit = new ProduitDTO();
		produit.setReferenceProduit("PdToA");
		produit.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
		facade.getServiceProduit().save(produit);
		
		produit = facade.getServiceProduit().getProduitByRef("PdToA");
		produit.setNomProduit("modifier");
		
		facade.getServiceProduit().update(produit);
		
		Assert.assertEquals("modifier", facade.getServiceProduit().getProduitByRef("PdToA").getNomProduit());
	}
	
	@Test
	@Rollback(true)
	public void getAll() {
		for(int i=0; i<5; i++) {
			ProduitDTO produit = new ProduitDTO();
			produit.setNomProduit("Pn"+i);
			produit.setReferenceProduit("ref"+i);
			produit.setNomImageProduit("panini.png");
			produit.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
			
			IngredientDTO ingredient = new IngredientDTO();
			ingredient.setReferenceIngredient("bacon"+i);
			ingredient.setNomIngredient("bacon");
			
			produit.getIngredients().add(ingredient);
			
			facade.getServiceProduit().save(produit);
		}
		
		System.out.println("START -------------------- "+facade.getServiceProduit().getAllProduit().size());
		for(ProduitDTO produitDTO : facade.getServiceProduit().getAllProduit()) {
			System.out.println(" Produit  : [ "+produitDTO.getNomProduit()+"]");
			for(IngredientDTO ingredientDTO : produitDTO.getIngredients()) {
				System.out.println(ingredientDTO.getReferenceIngredient());
			}
		}
		System.out.println("STOP");
	}
	
	@Test
	@Rollback(true)
	public void getAllLazy() {
		for(int i=0; i<5; i++) {
			ProduitDTO produit = new ProduitDTO();
			produit.setNomProduit("Pn"+i);
			produit.setReferenceProduit("ref"+i);
			produit.setNomImageProduit("panini.png");
			produit.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
			
			IngredientDTO ingredient = new IngredientDTO();
			ingredient.setReferenceIngredient("bacon"+i);
			ingredient.setNomIngredient("bacon");
			
			produit.getIngredients().add(ingredient);
			
			facade.getServiceProduit().save(produit);
		}
		
		for(ProduitDTO produitDTO : facade.getServiceProduit().getAllProduitLazy()) {
			Assert.assertEquals(0, produitDTO.getIngredients().size());
		}
	}
}
