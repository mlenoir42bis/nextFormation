package com.apps.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOCommande;
import com.apps.entity.Commande;

@Transactional
@Service
public class DaoCommandeImpl implements IDAOCommande {
	
	private static final Logger	logger	= Logger.getLogger(DaoClientImpl.class);
	
	protected EntityManager		em;
	
	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void save(Commande commande) {
		logger.info("save commande");
		this.em.persist(commande);
	}
	
	@Override
	public Commande find(Long commandeID) {
		logger.info("find commande by id");
		return this.em.find(Commande.class, commandeID);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Commande> getAll() {
		logger.info("get all commande");
		Query q = this.em.createQuery("SELECT DISTINCT c FROM Commande c LEFT JOIN FETCH c.ligneCommande");
		return (List<Commande>) q.getResultList();
	}
	
	@Override
	public void update(Commande commande) {
		logger.info("update commande");
		this.em.merge(commande);
	}
	
	@Override
	public void remove(Commande commande) {
		logger.info("remove commande");
		commande = this.em.merge(commande);
		this.em.remove(commande);
	}
	
	@Override
	public Commande find(String referenceCommande) {
		logger.info("find produit");
		TypedQuery<Commande> queryCommandeByReference =  em.createNamedQuery("Commande.findByReferenceCommande", Commande.class);
		queryCommandeByReference.setParameter("referenceCommande", referenceCommande);
		return (Commande) queryCommandeByReference.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> getAllLazy() {
		logger.info("get all commande");
		Query q = this.em.createQuery("SELECT DISTINCT FROM Commande");
		return (List<Commande>) q.getResultList();
	}
}
