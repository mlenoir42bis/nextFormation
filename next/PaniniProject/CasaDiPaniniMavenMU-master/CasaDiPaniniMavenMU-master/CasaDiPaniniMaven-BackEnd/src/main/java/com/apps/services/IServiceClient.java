package com.apps.services;

import java.util.List;

import com.apps.dto.ClientDTO;

public interface IServiceClient {

	boolean save(ClientDTO clientDTO);
	ClientDTO get(Long clientID);
    List<ClientDTO> getAll();
    void update(ClientDTO clientDTO);
	void remove(ClientDTO clientDTO);
	ClientDTO connecter(String email, String pwd);
	ClientDTO get(String email);
}
