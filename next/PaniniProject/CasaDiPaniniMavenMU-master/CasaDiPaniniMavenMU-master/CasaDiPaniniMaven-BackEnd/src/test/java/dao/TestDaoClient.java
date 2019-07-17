package dao;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apps.dao.IDaoClient;
import com.apps.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDaoClient {
	
	@Autowired
	IDaoClient clientDao;
	
	@Test
	@Rollback(false)
	public void creerClient() { 
		Client client = new Client();
		client.setEmailClient("j.c@gmail.com");
		client.setLevel(1);
		client.setLogin("sei");
		client.setNomClient("c");
		client.setPrenomClient("j");
		client.setPassword("motDePasseTest");
		clientDao.save(client);
		
		Client findedClient = clientDao.find(1L);
		Assert.assertNotNull(findedClient);
	}
	
	@Test
	@Rollback(false)
	public void creerClientDouble() { 
		Client client = new Client();
		client.setEmailClient("m.k@gmail.com");
		client.setLevel(1);
		client.setLogin("kev");
		client.setNomClient("m");
		client.setPrenomClient("k");
		client.setPassword("motDePasseTest2");
		
		Assert.assertEquals(true, clientDao.save(client));
		
		Client findedClient = clientDao.find(1L);
		Assert.assertNotNull(findedClient);
	}
	
}
