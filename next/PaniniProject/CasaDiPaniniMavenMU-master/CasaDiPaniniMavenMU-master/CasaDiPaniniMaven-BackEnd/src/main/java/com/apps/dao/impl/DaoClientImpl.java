package com.apps.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dao.IDaoClient;
import com.apps.entity.Client;

@Transactional
@Repository
public class DaoClientImpl implements IDaoClient {
    
    private static final Logger logger = Logger.getLogger(DaoClientImpl.class);

    protected EntityManager em;
    
    @PersistenceContext(unitName="entityManagerFactory")
    public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
    
    @Override
    public Long save( Client client ) {
        logger.info("dao save le client en parametre");
        this.em.persist(client);
        this.em.flush();
        return client.getIdClient();
    }

    @Override
    public Client find( Long clientID ) {
    	logger.info("dao retourne un client par id");
        return this.em.find(Client.class, clientID);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> getAll() {
    	Query q = this.em.createQuery("FROM Client");
		return (List<Client>) q.getResultList();
    }

    @Override
	public void update(Client client) {
    	logger.info("dao update le client en parametre");
		this.em.merge(client);
	}

    @Override
	public void remove(Client client) {
    	logger.info("dao remove le client en parametre");
		this.em.remove(client);
	}

    @Override
	public Client find(String email) {
    	logger.info("dao cherche le client dont le mail est en parametre");
    	try{
    		TypedQuery<Client> queryFindEmail =  em.createNamedQuery("Client.findByEmail", Client.class);
    		queryFindEmail.setParameter("emailClient", email);
    		return (Client) queryFindEmail.getSingleResult();
    	}catch(NoResultException e){
    		return null;
    	}
		
	}

}
