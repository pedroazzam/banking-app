package com.coding.task.service;

import java.util.List;

import com.coding.task.models.Account;
import com.coding.task.models.Client;

public interface AccountService {
	
	public List<Account> findAll();
	
	public Account findByClient(Client client);
	
	public void save(Account account);
	
	public void updateAccount(Account account);
	
}
