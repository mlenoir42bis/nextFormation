package com.apps.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDaoClient;
import com.apps.dto.ClientDTO;
import com.apps.entity.Client;
import com.apps.model.Jasypt;
import com.apps.services.IServiceClient;

@Transactional
@Service
public class ServiceClientImpl implements IServiceClient {
	
	@Autowired
	private IDaoClient			clientDao;
	@Autowired
	private Mapper				mapper;
	
	private static final Logger	logger	= Logger.getLogger(ServiceClientImpl.class);
	
	@Override
	public boolean save(ClientDTO clientDTO) {
		boolean saved = false;
		
		if (this.clientDao.find(clientDTO.getEmailClient()) == null) {
			logger.info("Service client passe le client au dao !");
			String passwordCrypter = Jasypt.crypterMotsDePasse(clientDTO.getPassword());
			logger.info("--------------------"+passwordCrypter);
			clientDTO.setPassword(passwordCrypter);
			if (clientDao.save(this.mapper.map(clientDTO, Client.class)) != null) {
				saved = true;
			}
		}
		return saved;
	}
	
	@Override
	public ClientDTO get(Long clientID) {
		logger.info("Service client passe le clientID a trouver au dao !");
		return this.mapper.map(clientDao.find(clientID), ClientDTO.class);
	}
	
	@Override
	public ClientDTO get(String email) {
		logger.info("Service client passe le mail client a trouver au dao !");
		return this.mapper.map(clientDao.find(email), ClientDTO.class);
	}
	
	@Override
	public List<ClientDTO> getAll() {
		logger.info("Service client demande la lsite des clients au dao !");
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		for (Client client : clientDao.getAll()) {
			clientDTOs.add(mapper.map(client, ClientDTO.class));
		}
		return clientDTOs;
	}
	
	@Override
	public void update(ClientDTO clientDTO) {
		logger.info("Service client passe le client au dao !");
		this.clientDao.update(mapper.map(clientDTO, Client.class));
	}
	
	@Override
	public void remove(ClientDTO clientDTO) {
		logger.info("Service client passe le client au dao !");
		this.clientDao.remove(mapper.map(clientDTO, Client.class));
	}
	
	@Override
	public ClientDTO connecter(String email, String password) {
		ClientDTO clientDTO = this.get(email);
		if (clientDTO != null) {
			if (Jasypt.deCrypterMotsDePasse(clientDTO.getPassword(), password)) {
				logger.info("Connecté");
			} else {
				logger.info("Erreur de connexion, mot de passe incorrect");
				clientDTO = null;
			}
		}
		logger.info("Non connecté - email incorrect");
		return clientDTO;
	}
}
