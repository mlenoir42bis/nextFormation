package dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dto.ClientDTO;
import com.apps.facade.IFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDtoClient {
	
	@Autowired
	IFacade facade;
	
	@Test
	@Rollback(true)
	public void addClient() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setEmailClient("j.c@gmail.com");
		clientDTO.setLevel(1);
		clientDTO.setLogin("sei");
		clientDTO.setNomClient("c");
		clientDTO.setPrenomClient("j");
		clientDTO.setPassword("motDePasseTest");
		
		facade.getServiceClient().save(clientDTO);
		
		ClientDTO findedClient = facade.getServiceClient().get("j.c@gmail.com");
		Assert.assertNotNull(findedClient);
	}
	
	@Test
	@Rollback(true)
	public void connecterClient() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setEmailClient("k.m@gmail.com");
		clientDTO.setLevel(1);
		clientDTO.setLogin("kev");
		clientDTO.setNomClient("m");
		clientDTO.setPrenomClient("k");
		clientDTO.setPassword("motDePasseTest2");
		facade.getServiceClient().save(clientDTO);
		
		ClientDTO clientDtoConnected = facade.getServiceClient().connecter("k.m@gmail.com", "motDePasseTest2");
		Assert.assertNotNull(clientDtoConnected);
	}
	
}
