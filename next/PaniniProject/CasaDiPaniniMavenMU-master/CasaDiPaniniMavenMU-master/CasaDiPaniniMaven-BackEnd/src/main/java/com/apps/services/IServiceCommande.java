package com.apps.services;

import java.util.List;

import com.apps.dto.CommandeDTO;

public interface IServiceCommande {
	void save(CommandeDTO commandeDTO);
	CommandeDTO get(Long commandeID);
    List<CommandeDTO> getAll();
    void update(CommandeDTO commandeDTO);
	void setStatutCommande(CommandeDTO commandeDTO);
	CommandeDTO get(String commandeID);
	List<CommandeDTO> getAllLazy();
	void remove(CommandeDTO commandeDTO);
}
