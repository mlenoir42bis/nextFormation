package com.apps.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apps.entity.model.StatutCommande;

public class CommandeDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3388154952307045439L;
	private Long commandeID;
	private List<LigneCommandeDTO> ligneCommande;
	private String referenceCommande;
	private Date dateCommande;
	private int remiseCommande;
	private double montantTotalCommande;
	private StatutCommande statutCommande;
	
	public CommandeDTO() {
		this.setLigneCommande(new ArrayList<LigneCommandeDTO>());
	}
	
	@Override
	public String toString() {
		return "commande n�"+this.referenceCommande;
	}

	public Long getCommandeID() {
		return commandeID;
	}

	public void setCommandeID(Long commandeID) {
		this.commandeID = commandeID;
	}

	public List<LigneCommandeDTO> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommandeDTO> ligneCommande) {
		this.ligneCommande = ligneCommande;
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
}
