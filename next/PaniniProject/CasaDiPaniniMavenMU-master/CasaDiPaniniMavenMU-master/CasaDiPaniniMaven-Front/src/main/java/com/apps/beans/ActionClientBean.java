package com.apps.beans;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.apps.dto.ClientDTO;
import com.apps.facade.IFacade;

@Controller
@Scope("request")
public class ActionClientBean {
	
	@Autowired
	private IFacade				facade;
	
	@Autowired
	private SessionClientBean	sessionClientBean;
	
	private ClientDTO			clientDTO	= new ClientDTO();
	private String				email;
	private String				password;
	
	public String creerClient() {
		if (facade.getServiceClient().save(clientDTO) == false) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email already used", "Changer votre Email");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			return "inscription";
		}
		return "monCompteSuccess";
	}
	
	public String modifierClient() {
		facade.getServiceClient().update(clientDTO);
		return "mon_compte";
	}
	
	public String supprimerClient() {
		facade.getServiceClient().remove(clientDTO);
		return "index";
	}
	
	public String connecterClient() {
		ClientDTO clientDTO = facade.getServiceClient().connecter(email, password);
		
		if (clientDTO == null && facade.getServiceClient().get(email) != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid password", "Mot de passe incorrect");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			return "index";
		} else if (clientDTO == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid Email", "email incorrect");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			return "index";
		}
		sessionClientBean.setSessionClient(clientDTO);
		return "monCompte";
	}
	
	public String deconnecterClient() {
		sessionClientBean.setSessionClient(null);
		return "index";
	}
	
	// Getter Setter
	public ClientDTO getClientDTO() {
		return this.clientDTO;
	}
	
	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
