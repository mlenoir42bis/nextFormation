package com.apps.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOMenu;
import com.apps.dao.IDAOProduit;
import com.apps.dao.IDAOProduitComposer;
import com.apps.dto.ProduitDTO;
import com.apps.entity.Menu;
import com.apps.entity.ProduitComposer;
import com.apps.entity.model.CategorieProduit;
import com.apps.services.IServiceProduit;

@Service
@Transactional
public class ServiceProduitImpl implements IServiceProduit {
	
	@Autowired
	private IDAOProduit			produitDAO;
	@Autowired
	private IDAOMenu			menuDAO;
	@Autowired
	private IDAOProduitComposer	produitComposerDAO;
	@Autowired
	private Mapper mapper;
	
	private static final Logger	logger	= Logger.getLogger(ServiceClientImpl.class);
		
	@Override
	public List<ProduitDTO> getAllProduit() {
		logger.info("Service demande au dao la liste des produits lourde");
		
		List<ProduitDTO> produitDTOs = new ArrayList<ProduitDTO>();
		
		for (Menu menu : this.menuDAO.getAllMenu()) {
			produitDTOs.add(this.mapper.map(menu, ProduitDTO.class));
		}
		
		for (ProduitComposer produitComposer : this.produitComposerDAO.getAll()) {
			produitDTOs.add(this.mapper.map(produitComposer, ProduitDTO.class));
		}
		return produitDTOs;
	}
	
	@Override
	public List<ProduitDTO> getAllMenu() {
		logger.info("Service demande au dao la liste des produits lourde");
		
		List<ProduitDTO> produitDTOs = new ArrayList<ProduitDTO>();
		
		for (Menu menu : this.menuDAO.getAllMenu()) {
			produitDTOs.add(this.mapper.map(menu, ProduitDTO.class));
		}
		return produitDTOs;
	}
	
	@Override
	public List<ProduitDTO> getAllProduitComposer() {
		logger.info("Service demande au dao la liste des produits lourde");
		
		List<ProduitDTO> produitDTOs = new ArrayList<ProduitDTO>();
		
		for (ProduitComposer produitComposer : this.produitComposerDAO.getAll()) {
			produitDTOs.add(this.mapper.map(produitComposer, ProduitDTO.class));
		}
		return produitDTOs;
	}
	
	@Override
	public List<ProduitDTO> getAllProduitLazy() {
		logger.info("Service demande au dao la liste des produits lazy");
		
		List<ProduitDTO> produitDTOs = new ArrayList<ProduitDTO>();
		
		for (Menu menu : this.menuDAO.getAllMenu()) {
			produitDTOs.add(this.mapper.map(menu, ProduitDTO.class, "menu_lazy"));
		}
		
		for (ProduitComposer produitComposer : this.produitComposerDAO.getAll()) {
			produitDTOs.add(this.mapper.map(produitComposer, ProduitDTO.class, "produit_composer_lazy"));
		}
		return produitDTOs;
	}
	
	@Override
	public void save(ProduitDTO produitDTO) {
		logger.info("Service demande au dao de sauver le produit");
		
		if (produitDTO.getCategorieProduit() == CategorieProduit.MENU) {
			this.menuDAO.save(this.mapper.map(produitDTO, Menu.class));
		} else if (produitDTO.getCategorieProduit() == CategorieProduit.PRODUIT_COMPOSER) {
			this.produitComposerDAO.save(this.mapper.map(produitDTO, ProduitComposer.class));
		}
	}
	
	@Override
	public ProduitDTO getProduitByID(Long produitID) {
		logger.info("Service demande au dao le produit par id");
		return this.mapper.map(this.produitDAO.find(produitID), ProduitDTO.class);
	}
	
	@Override
	public ProduitDTO getProduitByRef(String referenceProduit) {
		logger.info("Service demande au dao le produit par ref");
		return this.mapper.map(this.produitDAO.find(referenceProduit), ProduitDTO.class);
	}
	
	@Override
	public void update(ProduitDTO produitDTO) {
		logger.info("Service demande au dao de metre a jour le produit");
		
		if (produitDTO.getCategorieProduit() == CategorieProduit.MENU) {
			this.menuDAO.update(this.mapper.map(produitDTO, Menu.class));
		} else if (produitDTO.getCategorieProduit() == CategorieProduit.PRODUIT_COMPOSER) {
			this.produitComposerDAO.update(this.mapper.map(produitDTO, ProduitComposer.class));
		}
	}
	
	@Override
	public void remove(ProduitDTO produitDTO) {
		logger.info("Service demande au dao de supprimer le produit");
		
		if (produitDTO.getCategorieProduit() == CategorieProduit.MENU) {
			this.menuDAO.remove(this.mapper.map(produitDTO, Menu.class));
		} else if (produitDTO.getCategorieProduit() == CategorieProduit.PRODUIT_COMPOSER) {
			this.produitComposerDAO.remove(this.mapper.map(produitDTO, ProduitComposer.class));
		}
	}
}
