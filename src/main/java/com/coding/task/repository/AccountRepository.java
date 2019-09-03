package com.coding.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.task.models.Account;
import com.coding.task.models.Client;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByClient(Client client);
	
}
