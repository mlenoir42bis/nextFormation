package com.apps.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.apps.entity.model.StatutCommande;

@Entity
@NamedQuery(name="Commande.findByReferenceCommande", query="SELECT c FROM Commande c WHERE c.referenceCommande = :referenceCommande")
public class Commande implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -447135691118146454L;
	
	@Id
	@GeneratedValue
	private Long commandeID;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy="commande", cascade=CascadeType.ALL)
	private List<LigneCommande> ligneCommande;
	@Column(nullable=true, length=25)
	private String referenceCommande;
	private Date dateCommande;
	@Column(nullable=true, length=3)
	private int remiseCommande;
	@Column(nullable=true, length=6)
	private double montantTotalCommande;
	@Column(nullable=true, length=10)
	private StatutCommande statutCommande;
	
	public Commande() {
		this.setLigneCommande(new ArrayList<LigneCommande>());
	}
	
	@Override
	public String toString() {
		return "commande n�"+this.referenceCommande;
	}

	//Getter Setter
	public Long getCommandeID() {
		return commandeID;
	}

	public void setCommandeID(Long commandeID) {
		this.commandeID = commandeID;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getReferenceCommande() {
		return referenceCommande;
	}

	public void setReferenceCommande(String referenceCommande) {
		this.referenceCommande = referenceCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getRemiseCommande() {
		return remiseCommande;
	}

	public void setRemiseCommande(int remiseCommande) {
		this.remiseCommande = remiseCommande;
	}

	public double getMontantTotalCommande() {
		return montantTotalCommande;
	}

	public void setMontantTotalCommande(double montantTotalCommande) {
		this.montantTotalCommande = montantTotalCommande;
	}

	public StatutCommande getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}

	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
}
