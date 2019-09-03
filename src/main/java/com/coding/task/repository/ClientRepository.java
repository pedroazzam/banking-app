package com.coding.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.task.models.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Client findByEmailAndPassword(String email, String password);
	
	Client findById(long id);
	
}
