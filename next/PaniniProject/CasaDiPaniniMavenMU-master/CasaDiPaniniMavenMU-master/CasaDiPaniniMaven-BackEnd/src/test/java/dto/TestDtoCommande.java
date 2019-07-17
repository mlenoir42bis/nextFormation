package dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dto.CommandeDTO;
import com.apps.dto.LigneCommandeDTO;
import com.apps.facade.IFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDtoCommande {
	
	@Autowired
	IFacade	facade;
	
	@Test
	@Rollback(true)
	public void ajoutCommande() {
		CommandeDTO commandeDTO = new CommandeDTO();
		commandeDTO.setReferenceCommande("cmd01");
		
		LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();
		ligneCommandeDTO.setCommande(commandeDTO);
		ligneCommandeDTO.setQuantite(8);
		
		commandeDTO.getLigneCommande().add(ligneCommandeDTO);
		
		facade.getServiceCommande().save(commandeDTO);
		Assert.assertEquals(1, facade.getServiceCommande().getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void removeCommande() {
		CommandeDTO commandeDTO = new CommandeDTO();
		commandeDTO.setReferenceCommande("cmd01");
		
		LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();
		ligneCommandeDTO.setCommande(commandeDTO);
		ligneCommandeDTO.setQuantite(8);
		
		commandeDTO.getLigneCommande().add(ligneCommandeDTO);
		
		facade.getServiceCommande().save(commandeDTO);
		commandeDTO = facade.getServiceCommande().get("cmd01");
		facade.getServiceCommande().remove(commandeDTO);
		
		Assert.assertEquals(0, facade.getServiceCommande().getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void findCommande() {
		CommandeDTO commandeDTO = new CommandeDTO();
		commandeDTO.setReferenceCommande("cmd01");
		
		LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();
		ligneCommandeDTO.setCommande(commandeDTO);
		ligneCommandeDTO.setQuantite(8);
		
		commandeDTO.getLigneCommande().add(ligneCommandeDTO);
		
		facade.getServiceCommande().save(commandeDTO);
		
		commandeDTO = facade.getServiceCommande().get("cmd01");
		
		Assert.assertNotNull(commandeDTO);
	}
	
	@Test
	@Rollback(true)
	public void updateCommande() {
		CommandeDTO commandeDTO = new CommandeDTO();
		commandeDTO.setReferenceCommande("cmd01");
		
		LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();
		ligneCommandeDTO.setCommande(commandeDTO);
		ligneCommandeDTO.setQuantite(8);
		
		commandeDTO.getLigneCommande().add(ligneCommandeDTO);
		
		facade.getServiceCommande().save(commandeDTO);
		
		commandeDTO = facade.getServiceCommande().get("cmd01");
		System.out.println(commandeDTO.getLigneCommande().get(0).getQuantite());
		
		commandeDTO.getLigneCommande().get(0).setQuantite(777);
		
		facade.getServiceCommande().update(commandeDTO);
		
		commandeDTO = facade.getServiceCommande().get("cmd01");
		Assert.assertEquals(777, commandeDTO.getLigneCommande().get(0).getQuantite());
	}
	
	@Test
	@Rollback(false)
	public void getAllCommandes() {
		for (int i = 0; i < 3; i++) {
			CommandeDTO commandeDTO = new CommandeDTO();
			commandeDTO.setReferenceCommande("cmd0"+i);
			for (int a = 0; a < 3; a++) {
				LigneCommandeDTO ligneCommandeDTO = new LigneCommandeDTO();
				ligneCommandeDTO.setCommande(commandeDTO);
				ligneCommandeDTO.setQuantite(1+a);
				
				commandeDTO.getLigneCommande().add(ligneCommandeDTO);
			}
			facade.getServiceCommande().save(commandeDTO);
		}
		
		//result test
		Assert.assertEquals(3, facade.getServiceCommande().getAll().size());
		
		if(facade.getServiceCommande().getAll().size() == 3) {
			System.out.println("-------------------------------------");
			for(CommandeDTO cmd : facade.getServiceCommande().getAll()) {
				System.out.println(cmd.getReferenceCommande()+":");
				for(LigneCommandeDTO l : cmd.getLigneCommande()) {
					System.out.println(l.getQuantite());
				}
				Assert.assertEquals(3, cmd.getLigneCommande().size());
				System.out.println("-------------------------------------");
			}
		}
	}
	
}