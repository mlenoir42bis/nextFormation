package com.apps.beans;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.apps.dto.ClientDTO;
import com.apps.model.Panier;

@Component
@Scope("session")
public class SessionClientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	ClientDTO sessionClient = new ClientDTO();
	Panier sessionPanier = new Panier();
	
	public ClientDTO getSessionClient() {
		return sessionClient;
	}
	
	public void setSessionClient(ClientDTO sessionClient) {
		this.sessionClient = sessionClient;
	}
	
	public Panier getSessionPanier() {
		return sessionPanier;
	}
	
	public void setSessionPanier(Panier sessionPanier) {
		this.sessionPanier = sessionPanier;
	}
		
	
	
}
