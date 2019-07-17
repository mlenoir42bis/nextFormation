package com.apps.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDAOProduit;
import com.apps.entity.Produit;

@Transactional
@Service
public class DAOProduitImpl implements IDAOProduit {
	
	private static final Logger	logger	= Logger.getLogger(DAOProduitImpl.class);
	protected EntityManager	em;
	
	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public Produit find(Long produitID) {
		logger.info("find produit");
		Produit p = this.em.find(Produit.class, produitID);
		return p;
	}
	
	@Override
	public Produit find(String referenceProduit) {
		logger.info("find produit");
		TypedQuery<Produit> queryProduitByReference =  em.createNamedQuery("Produit.findByReferenceProduit", Produit.class);
		queryProduitByReference.setParameter("referenceProduit", referenceProduit);
		return (Produit) queryProduitByReference.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends Produit> getAllProduit() {
		logger.info("get all produit");
		Query qm = this.em.createQuery("SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.produits");
		Query qs = this.em.createQuery("SELECT DISTINCT s FROM Sandwich s LEFT JOIN FETCH s.ingredients");
		List<? extends Produit> produits = new ArrayList<Produit>();
		produits.addAll(qm.getResultList());
		produits.addAll(qs.getResultList());
		return produits;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends Produit> getAllProduitLazy() {
		logger.info("get all produit");
		Query q = this.em.createQuery("SELECT DISTINCT FROM Produit");
		return q.getResultList();
	}
}
