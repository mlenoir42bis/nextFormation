package com.apps.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apps.dto.ClientDTO;
import com.apps.dto.CommandeDTO;
import com.apps.dto.IngredientDTO;
import com.apps.dto.ProduitDTO;
import com.apps.entity.model.CategorieProduit;
import com.apps.entity.model.StatutProduit;
import com.apps.entity.model.TypeProduit;
import com.apps.facade.IFacade;

@Component
public class ActionAdminBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long			serialVersionUID	= 1L;
	
	@Autowired
	private IFacade						facade;
	
	private ProduitDTO					produitDTO			= new ProduitDTO();
	private CommandeDTO					commandeDTO			= new CommandeDTO();
	
	private Date						date				= new Date();
	private Timestamp					timesatamp			= new Timestamp(date.getTime());
	
	private static final Logger			logger				= Logger.getLogger(ActionAdminBean.class);
	private DualListModel<ProduitDTO>	produitsDual;
	private DualListModel<IngredientDTO>	produitsDualIngred;
	
	private String						rep					= "";
	private UploadedFile				file;
	
	@PostConstruct
	public void initIt() throws Exception {
		this.setProduitsDual(new DualListModel<ProduitDTO>(facade.getServiceProduit().getAllProduitComposer(), produitDTO.getProduits()));
		this.setProduitsDualIngred(new DualListModel<IngredientDTO>(facade.getServiceIngredient().getAll(), produitDTO.getIngredients()));
		logger.info("init");
	}
	
	// gestion des produit
	public String addProduit() {
		Date date = new Date();
		Timestamp ref = new Timestamp(date.getTime());
		this.produitDTO.setReferenceProduit("" + ref);
		
		if (this.produitDTO.getNomImageProduit() == null)
			this.produitDTO.setNomImageProduit("produit.png");
		
		this.facade.getServiceProduit().save(produitDTO);
		
		return "index";
	}
	
	public void addProdToProd(ProduitDTO prod) {
		this.produitDTO.getProduits().add(prod);
		System.out.println(this.produitDTO.getProduits().size());
	}
	
	public void removeProduit() {
		this.facade.getServiceProduit().remove(produitDTO);
	}
	
	public void updateProduit() {
		this.facade.getServiceProduit().update(produitDTO);
	}
	
	public List<ProduitDTO> getProduits() {
		List<ProduitDTO> produitDTOs = this.facade.getServiceProduit().getAllProduit();
		return produitDTOs;
	}
	
	public List<ProduitDTO> getMenu() {
		List<ProduitDTO> produitDTOs = this.facade.getServiceProduit().getAllMenu();
		return produitDTOs;
	}
	
	public List<ProduitDTO> getProduitComposer() {
		List<ProduitDTO> produitDTOs = this.facade.getServiceProduit().getAllProduitComposer();
		return produitDTOs;
	}
	
	public ProduitDTO getProduitByID() {
		return this.facade.getServiceProduit().getProduitByID(produitDTO.getProduitID());
	}
	
	public ProduitDTO getProduitByRef() {
		return this.facade.getServiceProduit().getProduitByRef(produitDTO.getReferenceProduit());
	}
	
	public void setDisponibility() {
		this.facade.getServiceProduit().update(produitDTO);
	}
	
	// form produit admin
	public List<CategorieProduit> getCategories() {
		return Arrays.asList(CategorieProduit.values());
	}
	
	public List<TypeProduit> getTypes() {
		return Arrays.asList(TypeProduit.values());
	}
	
	public List<StatutProduit> getStatuts() {
		return Arrays.asList(StatutProduit.values());
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
				this.produitDTO.getProduits().add(prod);
				msg.setDetail(prod.getNomProduit());
			}
		} else {
			logger.info("delete");
			for (Object p : event.getItems()) {
				System.out.println(((ProduitDTO) p).getNomProduit());
				ProduitDTO prod = ((ProduitDTO) p);
				this.produitDTO.getProduits().remove(prod);
				msg.setDetail(prod.getNomProduit());
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onTransferIngred(TransferEvent event) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary("Items Transferred");
		
		if (event.isAdd()) {
			logger.info("Adding");
			for (Object p : event.getItems()) {
				System.out.println(((ProduitDTO) p).getNomProduit());
				ProduitDTO prod = ((ProduitDTO) p);
				this.produitDTO.getProduits().add(prod);
				msg.setDetail(prod.getNomProduit());
			}
		} else {
			logger.info("delete");
			for (Object p : event.getItems()) {
				System.out.println(((ProduitDTO) p).getNomProduit());
				ProduitDTO prod = ((ProduitDTO) p);
				this.produitDTO.getProduits().remove(prod);
				msg.setDetail(prod.getNomProduit());
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	// gestion des clients
	public void remove() {
		//
	}
	
	public void update() {
		//
	}
	
	public List<ClientDTO> getAllClient() {
		return this.facade.getServiceClient().getAll();
	}
	
	// gerer commande
	public void addCommande() {
		
	}
	
	public void updateCommande() {
		
	}
	
	public void removeCommande() {
		this.facade.getServiceCommande().remove(commandeDTO);
	}
	
	public void setStatutCommande() {
		this.facade.getServiceCommande().update(commandeDTO);
	}
	
	// gerer promotion
	
	// gestion des fichier uploader image
	public void upload(FileUploadEvent event) {
		this.produitDTO.setNomImageProduit(event.getFile().getFileName());
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		// Do what you want with the file
		try {
			this.copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void copyFile(String fileName, InputStream in) {
		// gets absolute path of the web application
		try {
			// write the inputStream to a FileOutputStream
			
			this.rep = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rep");
			
			ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
			String dir = extContext.getRealPath("/resources/images/" + this.rep + "/" + fileName);
			System.out.println(dir);
			OutputStream out = new FileOutputStream(new File(dir));
			
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			in.close();
			out.flush();
			out.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Getter Setter
	public Timestamp getTimesatamp() {
		return timesatamp;
	}
	
	public void setTimesatamp(Timestamp timesatamp) {
		this.timesatamp = timesatamp;
	}
	
	public ProduitDTO getProduitDTO() {
		return produitDTO;
	}
	
	public void setProduitDTO(ProduitDTO produitDTO) {
		this.produitDTO = produitDTO;
	}
	
	public CommandeDTO getCommandeDTO() {
		return commandeDTO;
	}
	
	public void setCommandeDTO(CommandeDTO commandeDTO) {
		this.commandeDTO = commandeDTO;
	}
	
	public UploadedFile getFile() {
		return file;
	}
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public String getRep() {
		return rep;
	}
	
	public void setRep(String rep) {
		this.rep = rep;
	}
	
	public DualListModel<ProduitDTO> getProduitsDual() {
		return produitsDual;
	}
	
	public void setProduitsDual(DualListModel<ProduitDTO> produitsDual) {
		this.produitsDual = produitsDual;
	}

	public DualListModel<IngredientDTO> getProduitsDualIngred() {
		return produitsDualIngred;
	}

	public void setProduitsDualIngred(DualListModel<IngredientDTO> produitsDualIngred) {
		this.produitsDualIngred = produitsDualIngred;
	}
}
