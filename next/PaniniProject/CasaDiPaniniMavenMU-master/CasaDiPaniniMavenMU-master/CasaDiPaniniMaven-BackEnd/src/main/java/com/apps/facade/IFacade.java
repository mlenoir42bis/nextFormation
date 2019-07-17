package com.apps.facade;

import com.apps.services.IServiceClient;
import com.apps.services.IServiceCommande;
import com.apps.services.IServiceIngredient;
import com.apps.services.IServiceProduit;

public interface IFacade {
    
    IServiceClient getServiceClient();
    IServiceProduit getServiceProduit();
    IServiceCommande getServiceCommande();
    IServiceIngredient getServiceIngredient();
}
