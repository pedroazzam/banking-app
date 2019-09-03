package com.coding.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.task.models.Client;
import com.coding.task.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	
	ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository newClientRepository) {
		clientRepository = newClientRepository;
	}
	
	@Override
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	@Override
	public Client findById(long id) {
		return clientRepository.findById(id);
	}
	
	@Override
	public Client findByEmailAndPassword(String email, String password) {
		return clientRepository.findByEmailAndPassword(email, password);
	}
	
	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

}
