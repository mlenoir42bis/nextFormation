package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOCommande;
import com.apps.entity.Commande;
import com.apps.entity.LigneCommande;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDaoCommande {
	
	@Autowired
	IDAOCommande commandeDAO;
	
	@Test
	@Rollback(true)
	public void ajouterCommande() {
		System.out.println("ADD commande");
		
		Commande commande = new Commande();
		commande.setReferenceCommande("cmd01");
		
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setCommande(commande);
		
		commande.getLigneCommande().add(ligneCommande);
		
		commandeDAO.save(commande);
		Assert.assertEquals(1, commandeDAO.getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void findProduit() {
		System.out.println("FIND commande");
		
		Commande commande = new Commande();
		commande.setReferenceCommande("cmd01");
		commandeDAO.save(commande);
		commande = commandeDAO.find("cmd01");
		Assert.assertNotNull(commande.getCommandeID());
	}
	
	@Test
	@Rollback(true)
	public void updateIngredient() {
		System.out.println("UPDATE commande");

		Commande commande = new Commande();
		commande.setReferenceCommande("cmd01");
		commandeDAO.save(commande);
		commande = commandeDAO.find("cmd01");
		
		commande.setMontantTotalCommande(254);
		commandeDAO.update(commande);
		
		Commande commandeToFind = commandeDAO.find("cmd01");
		
		boolean bool = false;
		if(254 == commandeToFind.getMontantTotalCommande())
			bool = true;
		
		Assert.assertEquals(true, bool);
	}
	
	@Test
	@Rollback(true)
	public void getAllCommande() {
		System.out.println("ADD commande");
		for(int i=0; i<5; i++) {
		Commande commande = new Commande();
		commande.setReferenceCommande("cmd"+i);
		
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setQuantite(i+2);
		ligneCommande.setCommande(commande);
		
		commande.getLigneCommande().add(ligneCommande);
		
		commandeDAO.save(commande);
		}
		
		System.out.println("-----------------------------------------------------------");
		for(Commande cmd : commandeDAO.getAll()) {
			cmd.getReferenceCommande();
			for(LigneCommande lgn : cmd.getLigneCommande()) {
				System.out.println(lgn.getQuantite());
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
}
