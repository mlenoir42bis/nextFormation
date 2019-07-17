package com.apps.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.apps.entity.model.CategorieProduit;
import com.apps.entity.model.StatutProduit;
import com.apps.entity.model.TypeProduit;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name="Produit.findByReferenceProduit", query="SELECT p FROM Produit p WHERE p.referenceProduit = :referenceProduit"),
		@NamedQuery(name="Menu.findByReferenceMenu", query="SELECT m FROM Menu m WHERE m.referenceProduit = :referenceMenu"),
		@NamedQuery(name="ProduitComposer.findByReferenceProduitComposer", query="SELECT s FROM ProduitComposer s WHERE s.referenceProduit = :referenceProduitComposer"),
})
public abstract class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 604548651610003728L;
	
	@Id
	@GeneratedValue
	private Long produitID;
	@Column(nullable=true, length=25)
	private String referenceProduit;
	@Column(nullable=true, length=2)
	private TypeProduit typeProduit;
	@Column(nullable=true, length=2)
	private CategorieProduit categorieProduit;
	@Column(nullable=true, length=25)
	private String nomProduit;
	@Column(nullable=true, length=25)
	private String nomImageProduit;
	@Column(nullable=true, length=6)
	private double prixProduit;
	@Column(nullable=true, length=1)
	private StatutProduit statutProduit;
	
	public Produit() {
		
	}
	
	@Override
	public String toString() {
		return "Categorie: "+this.categorieProduit+" type: "+this.typeProduit+" : "+this.nomProduit+" Prix : "+this.prixProduit+" Disponibilit� : "+this.statutProduit;
	}

	public TypeProduit getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNomImageProduit() {
		return nomImageProduit;
	}

	public void setNomImageProduit(String nomImageProduit) {
		this.nomImageProduit = nomImageProduit;
	}

	public StatutProduit getStatutProduit() {
		return statutProduit;
	}

	public void setStatutProduit(StatutProduit statutProduit) {
		this.statutProduit = statutProduit;
	}

	public String getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(String referenceProduit) {
		this.referenceProduit = referenceProduit;
	}
	public Long getProduitID() {
		return produitID;
	}

	public void setProduitID(Long produitID) {
		this.produitID = produitID;
	}

	public double getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
}
