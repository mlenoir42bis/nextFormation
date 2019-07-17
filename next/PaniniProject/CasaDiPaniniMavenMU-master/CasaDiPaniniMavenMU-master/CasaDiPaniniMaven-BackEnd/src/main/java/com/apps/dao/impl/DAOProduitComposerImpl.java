package com.apps.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOProduitComposer;
import com.apps.entity.ProduitComposer;

@Transactional
@Service
public class DAOProduitComposerImpl implements IDAOProduitComposer {
	
	private static final Logger	logger	= Logger.getLogger(DAOProduitComposerImpl.class);
	protected EntityManager	em;
	
	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public void save(ProduitComposer produitComposer) {
		logger.info("save Produit Composer");
		this.em.persist(produitComposer);
	}
	
	@Override
	public ProduitComposer find(Long produitComposerID) {
		logger.info("find Produit Composer");
		return this.em.find(ProduitComposer.class, produitComposerID);
	}
	
	@Override
	public ProduitComposer find(String referenceProduitComposer) {
		logger.info("find Produit Composer");
		TypedQuery<ProduitComposer> queryProduitComposerByReference =  em.createNamedQuery("ProduitComposer.findByReferenceProduitComposer", ProduitComposer.class);
		queryProduitComposerByReference.setParameter("referenceProduitComposer", referenceProduitComposer);
		return (ProduitComposer) queryProduitComposerByReference.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProduitComposer> getAll() {
		logger.info("get all Produit Composer");
		Query q = this.em.createQuery("SELECT DISTINCT pc FROM ProduitComposer pc LEFT JOIN FETCH pc.ingredients");
		return (List<ProduitComposer>) q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProduitComposer> getAllLazy() {
		logger.info("get all Produit Composer");
		Query q = this.em.createQuery("SELECT DISTINCT FROM ProduitComposer");
		return q.getResultList();
	}
	
	@Override
	public void update(ProduitComposer produitComposer) {
		logger.info("update Produit Composer");
		this.em.merge(produitComposer);
	}
	
	@Override
	public void remove(ProduitComposer produitComposer) {
		logger.info("remove Produit Composer");
		ProduitComposer produitComposerToRemove = this.em.merge(produitComposer);
		this.em.remove(produitComposerToRemove);
	}
}
