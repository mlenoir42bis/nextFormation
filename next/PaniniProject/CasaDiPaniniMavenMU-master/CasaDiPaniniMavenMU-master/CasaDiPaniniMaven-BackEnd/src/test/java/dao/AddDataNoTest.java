package dao;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOIngredient;
import com.apps.dao.IDAOMenu;
import com.apps.dao.IDAOProduitComposer;
import com.apps.entity.Ingredient;
import com.apps.entity.Menu;
import com.apps.entity.ProduitComposer;
import com.apps.entity.model.CategorieProduit;
import com.apps.entity.model.StatutProduit;
import com.apps.entity.model.TypeProduit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-conf.xml")
@Transactional
public class AddDataNoTest {

	@Autowired
	IDAOMenu menuDao;
	@Autowired
	IDAOProduitComposer produitComposerDao;
	@Autowired
	IDAOIngredient ingredientDao;

	@Test
	@Rollback(false)
	public void ajouterProduitExist() {

		System.out.println("ADD MENU");
		
		System.out.println("ADD PROD");
		for(int i=0; i<5; i++)  {
			ProduitComposer produitComposer = new ProduitComposer();
			produitComposer.setNomProduit("panini "+i);
			produitComposer.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);
			
			Date date = new Date();
			
			if(i==0)
				produitComposer.setReferenceProduit("refPaniniTest");
			else
				produitComposer.setReferenceProduit(""+new Timestamp(date.getTime())+i);
			
			produitComposer.setTypeProduit(TypeProduit.PANINI);
			produitComposer.setPrixProduit(03.8+i);
			produitComposer.setStatutProduit(StatutProduit.DISPONIBLE);
			produitComposer.setNomImageProduit("produit.png");

			Ingredient ingredient = new Ingredient();
			ingredient.setNomIngredient("chipo "+i);
			ingredient.setReferenceIngredient("ref_a "+i);
			ingredient.setNomImageIngredient("ingredient.png");
			
			Ingredient ingredient2 = new Ingredient();
			ingredient2.setNomIngredient("piment "+i);
			ingredient2.setReferenceIngredient("ref_b "+i);
			ingredient2.setNomImageIngredient("ingredient.png");
			
			ingredientDao.save(ingredient);
			ingredientDao.save(ingredient2);
			
			produitComposer.getIngredients().add(ingredient);
			produitComposer.getIngredients().add(ingredient2);
			
			produitComposerDao.save(produitComposer);
		}
		
			Menu menu = new Menu();
			menu.setNomProduit("menu 1");
			
			Date date = new Date();
			
			menu.setReferenceProduit(""+new Timestamp(date.getTime()));
			menu.setTypeProduit(TypeProduit.PANINI);
			menu.setCategorieProduit(CategorieProduit.MENU);
			menu.setPrixProduit(07.11);
			menu.setNomImageProduit("produit.png");
			menu.setStatutProduit(StatutProduit.DISPONIBLE);
			menu.getProduits().add(produitComposerDao.find("refPaniniTest"));
			menuDao.save(menu);
	}
}
