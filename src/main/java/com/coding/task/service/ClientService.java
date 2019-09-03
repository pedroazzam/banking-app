package com.coding.task.service;

import java.util.List;

import com.coding.task.models.Client;

public interface ClientService {
	
	public List<Client> findAll();
	
	public Client findById(long id);
	
	public Client findByEmailAndPassword(String email, String password);
	
	public Client save(Client client);
	
}
