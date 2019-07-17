package com.apps.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;

@Entity
@NamedQuery(name="Client.findByEmail", query="SELECT c FROM Client c WHERE c.emailClient = :emailClient")
public class Client implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3896327556166954260L;
    @Id
    @GeneratedValue
    private Long clientID;
    @Column(nullable=false, length=20)
    private String nomClient;
    @Column(nullable=false, length=20)
    private String prenomClient;
    @Column(nullable=false, length=100, unique = true)
    private String emailClient;
    @Column(nullable=false, length=15, unique = true)
    private String login;
    @Column(nullable=false, length=56)
    private String password;
    @Column(nullable=false, length=1)
    private int level;
    
    @OneToMany(mappedBy="client")
    private List<Commande> commandesClient;
    @OneToMany(mappedBy="client")
    private List<Commande> historiqueCommandesClient;
    
    private static final Logger logger = Logger.getLogger(Client.class);
    
    public Client() {
        logger.info("init d'un client");
        this.setCommandesClient(new ArrayList<Commande>());
        this.setHistoriqueCommandesClient(new ArrayList<Commande>());
    }
    
    public Client( String nomClient, String prenomClient, String emailClient ) {
    	this.setNomClient(nomClient);
        this.setPrenomClient(prenomClient);
        this.setEmailClient(emailClient);
    }
    
    public Client(String nomClient, String prenomClient, String emailClient,
			String password) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.emailClient = emailClient;
		this.password = password;
	}

	@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserID["+this.clientID+"] nom: "+this.nomClient+" prenom: "+this.prenomClient+" email: "+this.emailClient);
        return stringBuilder.toString();
    }

    public Long getIdClient() {
        return clientID;
    }

    public void setIdClient( Long clientID ) {
        this.clientID = clientID;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient( String nomClient ) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient( String prenomClient ) {
        this.prenomClient = prenomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient( String emailClient ) {
        this.emailClient = emailClient;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Commande> getCommandesClient() {
		return commandesClient;
	}

	public void setCommandesClient(List<Commande> commandesClient) {
		this.commandesClient = commandesClient;
	}

	public List<Commande> getHistoriqueCommandesClient() {
		return historiqueCommandesClient;
	}

	public void setHistoriqueCommandesClient(List<Commande> historiqueCommandesClient) {
		this.historiqueCommandesClient = historiqueCommandesClient;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
