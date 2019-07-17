package com.apps.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOMenu;
import com.apps.entity.Menu;

@Transactional
@Service
public class DAOMenuImpl implements IDAOMenu {
	
	private static final Logger	logger	= Logger.getLogger(DAOMenuImpl.class);
	protected EntityManager	em;
	
	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void save(Menu menu) {
		logger.info("save Menu");
		this.em.persist(menu);
	}
	
	@Override
	public Menu find(Long menuID) {
		logger.info("find Menu");
		return this.em.find(Menu.class, menuID);
	}
	
	@Override
	public Menu find(String referenceMenu) {
		logger.info("find Menu");
		TypedQuery<Menu> queryMenuByReference =  em.createNamedQuery("Menu.findByReferenceMenu", Menu.class);
		queryMenuByReference.setParameter("referenceMenu", referenceMenu);
		return (Menu) queryMenuByReference.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> getAllMenu() {
		logger.info("get all Menu");
		Query q = this.em.createQuery("SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.produits");
		return (List<Menu>) q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> getAllMenuLazy() {
		logger.info("get all Menu");
		Query q = this.em.createQuery("SELECT DISTINCT FROM Menu");
		return q.getResultList();
	}
	
	@Override
	public void update(Menu menu) {
		logger.info("update Menu");
		this.em.merge(menu);
	}
	
	@Override
	public void remove(Menu menu) {
		logger.info("remove Menu");
		Menu menuToRemove = this.em.merge(menu);
		this.em.remove(menuToRemove);
	}
}
