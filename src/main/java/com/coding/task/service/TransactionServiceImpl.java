package com.coding.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.task.models.Account;
import com.coding.task.models.Transaction;
import com.coding.task.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
	@Override
	public List<Transaction> transactionList(Account account){
		return transactionRepository.findByAccount(account);
	}
}
