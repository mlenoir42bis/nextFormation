package com.apps.dao;

import java.util.List;

import com.apps.entity.Client;

public interface IDaoClient {

	Long save(Client client);
    Client find(Long clientID);
    List<Client> getAll();
	void update(Client client);
	void remove(Client client);
	Client find(String email);
}
