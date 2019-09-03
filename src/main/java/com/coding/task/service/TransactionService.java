package com.coding.task.service;

import java.util.List;

import com.coding.task.models.Account;
import com.coding.task.models.Transaction;

public interface TransactionService {
	
	public void saveTransaction(Transaction transaction);
	
	public List<Transaction> transactionList(Account account);

}
