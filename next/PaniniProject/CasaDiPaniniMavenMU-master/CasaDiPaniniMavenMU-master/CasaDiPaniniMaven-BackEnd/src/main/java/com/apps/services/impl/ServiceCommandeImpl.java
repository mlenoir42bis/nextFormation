package com.apps.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOCommande;
import com.apps.dto.CommandeDTO;
import com.apps.entity.Commande;
import com.apps.services.IServiceCommande;

@Transactional
@Service
public class ServiceCommandeImpl implements IServiceCommande {
	
	@Autowired
	private IDAOCommande		commandeDAO;
	@Autowired
	private Mapper mapper;
	
	private static final Logger	logger	= Logger.getLogger(ServiceClientImpl.class);
	
	@Override
	public void save(CommandeDTO commandeDTO) {
		logger.info("service commande passe une commande au dao");
		this.commandeDAO.save(this.mapper.map(commandeDTO, Commande.class));
	}
	
	@Override
	public CommandeDTO get(Long commandeID) {
		logger.info("service commande un id au dao");
		return this.mapper.map(this.commandeDAO.find(commandeID), CommandeDTO.class);
	}
	
	@Override
	public CommandeDTO get(String referenceCommande) {
		logger.info("service commande un id au dao");
		return this.mapper.map(this.commandeDAO.find(referenceCommande), CommandeDTO.class);
	}
	
	@Override
	public List<CommandeDTO> getAll() {
		logger.info("service commande demande la liste lourde des commande au dao");
		List<CommandeDTO> listDTO = new ArrayList<CommandeDTO>();
		for(Commande commande : this.commandeDAO.getAll()) {
			listDTO.add(this.mapper.map(commande, CommandeDTO.class));
		}
		return listDTO;
	}
	
	@Override
	public List<CommandeDTO> getAllLazy() {
		logger.info("service commande demande la liste des commande au dao");
		List<CommandeDTO> listDTO = new ArrayList<CommandeDTO>();
		
		for(Commande commande : this.commandeDAO.getAllLazy()) {
			listDTO.add(this.mapper.map(commande, CommandeDTO.class, "commande_lazy"));
		}
		return listDTO;
	}
	
	@Override
	public void update(CommandeDTO commandeDTO) {
		logger.info("service commande demande un update au dao");
		this.commandeDAO.update(this.mapper.map(commandeDTO, Commande.class));
	}
	
	@Override
	public void remove(CommandeDTO commandeDTO) {
		logger.info("service commande demande une supsression au dao");
		this.commandeDAO.remove(this.mapper.map(commandeDTO, Commande.class));
	}
	
	@Override
	public void setStatutCommande(CommandeDTO commandeDTO) {
		this.commandeDAO.update(this.mapper.map(commandeDTO, Commande.class));
	}
}
