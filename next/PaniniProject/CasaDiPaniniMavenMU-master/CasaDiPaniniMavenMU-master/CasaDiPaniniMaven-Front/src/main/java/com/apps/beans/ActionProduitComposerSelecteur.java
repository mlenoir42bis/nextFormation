package com.apps.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.apps.dto.ProduitDTO;
import com.apps.facade.IFacade;

@Component
@Scope("session")
public class ActionProduitComposerSelecteur implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private IFacade facade;
	
	private static final Logger logger = Logger.getLogger(ActionProduitComposerSelecteur.class);
	
	private DualListModel<ProduitDTO>	produitsDual;
	private List<ProduitDTO> listProduitDTO;
	
	@PostConstruct
	public void initIt() throws Exception {
		this.listProduitDTO = new ArrayList<ProduitDTO>();
		this.setProduitsDual(new DualListModel<ProduitDTO>(facade.getServiceProduit().getAllProduitComposer(), listProduitDTO));
		logger.info("init");
	}
	
	public void onTransfer(TransferEvent event) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary("Items Transferred");
		
		if (event.isAdd()) {
			logger.info("Adding");
			for (Object p : event.getItems()) {
				System.out.println(((ProduitDTO) p).getNomProduit());
				ProduitDTO prod = ((ProduitDTO) p);
				this.listProduitDTO.add(prod);
				msg.setDetail(prod.getNomProduit());
			}
		} else {
			logger.info("delete");
			for (Object p : event.getItems()) {
				System.out.println(((ProduitDTO) p).getNomProduit());
				ProduitDTO prod = ((ProduitDTO) p);
				this.listProduitDTO.remove(prod);
				msg.setDetail(prod.getNomProduit());
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public DualListModel<ProduitDTO> getProduitsDual() {
		return produitsDual;
	}
	public void setProduitsDual(DualListModel<ProduitDTO> produitsDual) {
		this.produitsDual = produitsDual;
	}
	public List<ProduitDTO> getListProduitDTO() {
		return listProduitDTO;
	}
	public void setListProduitDTO(List<ProduitDTO> listProduitDTO) {
		this.listProduitDTO = listProduitDTO;
	}
}
