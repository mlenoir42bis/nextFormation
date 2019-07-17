package com.apps.facade;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apps.services.IServiceClient;
import com.apps.services.IServiceCommande;
import com.apps.services.IServiceIngredient;
import com.apps.services.IServiceProduit;

@Component
public class FacadeImpl implements IFacade, Serializable {
    /**
	 * 
	 */
	private static final long	serialVersionUID	= -5295923302149865880L;
	
	@Autowired
    private IServiceClient serviceClient;
    @Autowired
    private IServiceCommande serviceCommande;
    @Autowired
    private IServiceIngredient serviceIngredient;
    @Autowired
    private IServiceProduit serviceProduit;
    
    private static final Logger logger = Logger.getLogger(FacadeImpl.class);
    
    @Override
    public IServiceClient getServiceClient() {
        logger.info("Recuperation du serviceClient");
        return serviceClient;
    }
    
    public void setServiceClient( IServiceClient serviceClient ) {
        this.serviceClient = serviceClient;
    }
    
    @Override
	public IServiceCommande getServiceCommande() {
		return serviceCommande;
	}

	public void setServiceCommande(IServiceCommande serviceCommande) {
		this.serviceCommande = serviceCommande;
	}
	
	@Override
	public IServiceIngredient getServiceIngredient() {
		return serviceIngredient;
	}

	public void setServiceIngredient(IServiceIngredient serviceIngredient) {
		this.serviceIngredient = serviceIngredient;
	}

	@Override
	public IServiceProduit getServiceProduit() {
		return serviceProduit;
	}

	public void setServiceProduit(IServiceProduit serviceProduit) {
		this.serviceProduit = serviceProduit;
	}
}
