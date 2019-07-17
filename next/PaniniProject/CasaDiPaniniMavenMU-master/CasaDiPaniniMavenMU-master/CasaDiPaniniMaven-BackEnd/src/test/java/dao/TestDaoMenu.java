package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOMenu;
import com.apps.dao.IDAOProduitComposer;
import com.apps.entity.Ingredient;
import com.apps.entity.Menu;
import com.apps.entity.ProduitComposer;
import com.apps.entity.model.CategorieProduit;
import com.apps.entity.model.TypeProduit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDaoMenu {

	@Autowired
	IDAOMenu menuDao;
	@Autowired
	IDAOProduitComposer sandwichDao;

	@Test
	@Rollback(true)
	public void ajouterProduit() {
		System.out.println("ADD PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setTypeProduit(TypeProduit.PANINI);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("piment");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("chipo");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);

		menu.getProduits().add(sandwich);

		menuDao.save(menu);

		System.out.println(menuDao.getAllMenu().size());
		Assert.assertEquals(1, menuDao.getAllMenu().size());
	}

	@Test
	@Rollback(true)
	public void getAllProduit() {
		System.out.println("Get ALL PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setReferenceProduit("menu0N");
		menu.setTypeProduit(TypeProduit.MENU);
		menu.setCategorieProduit(CategorieProduit.MENU);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");
		sandwich.setCategorieProduit(CategorieProduit.PRODUIT_COMPOSER);

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("piment");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("chipo");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);

		menu.getProduits().add(sandwich);
		menuDao.save(menu);

		System.out.println("------------" + menuDao.getAllMenu().size()+ "--------------");
		for(Menu m :  menuDao.getAllMenu()) {
			System.out.println(m.getNomProduit());
			for (ProduitComposer sm : m.getProduits()) {
				System.out.println("["+sm.getNomProduit()+"]");
				for (Ingredient i : sm.getIngredients()) {
					System.out.println("-->"+i.getNomIngredient());
				}
			}
			System.out.println("--------------------------");
		}
	}

	@Test
	@Rollback(true)
	public void ajouterProduitExist() {

		System.out.println("ADD PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setTypeProduit(TypeProduit.PANINI);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);
		sandwichDao.save(sandwich);

		menu.getProduits().add(sandwich);

		menuDao.save(menu);

		System.out.println(menuDao.getAllMenu().size());
		Assert.assertEquals(1, menuDao.getAllMenu().size());
	}

	@Test
	@Rollback(true)
	public void removeProduit() {
		System.out.println("Remove PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setReferenceProduit("menu01");
		menu.setTypeProduit(TypeProduit.PANINI);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);
		sandwichDao.save(sandwich);

		menu.getProduits().add(sandwich);
		menuDao.save(menu);

		menu = (Menu) menuDao.find("menu01");
		menuDao.remove(menu);

		Assert.assertEquals(0, menuDao.getAllMenu().size());
	}

	@Test
	@Rollback(true)
	public void findProduit() {
		System.out.println("FIND PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setReferenceProduit("menu01");
		menu.setTypeProduit(TypeProduit.PANINI);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);
		sandwichDao.save(sandwich);

		menu.getProduits().add(sandwich);
		menuDao.save(menu);

		menu = (Menu) menuDao.find("menu01");

		Assert.assertEquals("menu", menu.getNomProduit());
	}

	@Test
	@Rollback(true)
	public void updateProduit() {
		System.out.println("UPDATE PROD");

		Menu menu = new Menu();
		menu.setNomProduit("menu");
		menu.setReferenceProduit("menu01");
		menu.setTypeProduit(TypeProduit.PANINI);

		ProduitComposer sandwich = new ProduitComposer();
		sandwich.setNomProduit("sandwich 1");

		Ingredient ingredient = new Ingredient();
		ingredient.setNomIngredient("bacon");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setNomIngredient("cheese");

		sandwich.getIngredients().add(ingredient);
		sandwich.getIngredients().add(ingredient2);
		sandwichDao.save(sandwich);

		menu.getProduits().add(sandwich);
		menuDao.save(menu);

		menu = (Menu) menuDao.find("menu01");
		menu.setNomProduit("menu modifier");

		menuDao.update(menu);

		System.out.println(menuDao.find("menu01").getNomProduit());
		Assert.assertEquals("menu modifier", menuDao.find("menu01")
				.getNomProduit());
	}
}
