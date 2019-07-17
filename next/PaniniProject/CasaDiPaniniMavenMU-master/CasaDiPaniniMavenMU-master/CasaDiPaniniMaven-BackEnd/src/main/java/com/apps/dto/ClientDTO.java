package com.apps.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

public class ClientDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 7428429216162763166L;
	private Long	clientID;
	@Size(min=2,max=5)
	private String	nomClient;
	private String	prenomClient;
	private String	emailClient;
	private String	login;
	private String	password;
	private int		level;
	private List<CommandeDTO> commandesClient;
	private List<CommandeDTO> historiqueCommandesClient;
	
	public ClientDTO() {
		this.setCommandesClient(new ArrayList<CommandeDTO>());
		this.setHistoriqueCommandesClient(new ArrayList<CommandeDTO>());
	}
	
	@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserID["+this.clientID+"] nom: "+this.nomClient+" prenom: "+this.prenomClient+" email: "+this.emailClient);
        return stringBuilder.toString();
    }
	
	public Long getClientID() {
		return clientID;
	}

	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<CommandeDTO> getCommandesClient() {
		return commandesClient;
	}

	public void setCommandesClient(List<CommandeDTO> commandesClient) {
		this.commandesClient = commandesClient;
	}

	public List<CommandeDTO> getHistoriqueCommandesClient() {
		return historiqueCommandesClient;
	}

	public void setHistoriqueCommandesClient(List<CommandeDTO> historiqueCommandesClient) {
		this.historiqueCommandesClient = historiqueCommandesClient;
	}
}
