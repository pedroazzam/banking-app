package com.coding.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.task.models.Account;
import com.coding.task.models.Client;
import com.coding.task.repository.AccountRepository;
import com.coding.task.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findByClient(Client client) {
		return accountRepository.findByClient(client);
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

}
