package com.coding.task.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.task.models.Account;
import com.coding.task.models.Client;
import com.coding.task.models.ClientOnSession;
import com.coding.task.models.Transaction;
import com.coding.task.service.AccountService;
import com.coding.task.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="REST API - TRANSACTIONS")
@CrossOrigin(origins="*")
public class TransactionController {
	
	Client loggedClient;
	Account account;
	
	@Autowired
	TransactionService transactionService;
	@Autowired
	AccountService accountService;
	
	@GetMapping("/account/myaccount/statement")
	@ApiOperation(value="Return client account statment")
	public List<Transaction> transactions() {
		try {
			if (ClientOnSession.getLogged().getEmail()!=null) {
				loggedClient = ClientOnSession.getLogged();
				account = accountService.findByClient(loggedClient);
				return transactionService.transactionList(account);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Access denied!");
		}
		throw new IllegalArgumentException("Access denied!");
	}
	
	@PostMapping("/account/myaccount/deposit")
	@ApiOperation(value="Register deposit transaction on client's account")
	public void deposit(@RequestBody Transaction newTransaction) {
		try {
			if (ClientOnSession.getLogged().getEmail()!=null) {
				loggedClient = ClientOnSession.getLogged();
				newTransaction.setDate(new Date());
				newTransaction.setType("Deposit");
				account = accountService.findByClient(loggedClient);
				double newBalance = account.getBalance()+newTransaction.getValue();
				account.setBalance(newBalance);
				accountService.updateAccount(account);
				newTransaction.setAccount(account);
				transactionService.saveTransaction(newTransaction);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Access denied!");
		}
		throw new IllegalArgumentException("Access denied!");
	}
	
	@PostMapping("/account/myaccount/withdrawal")
	@ApiOperation(value="Register withdrawal transaction on client's account")
	public void withdrawal(@RequestBody Transaction newTransaction)  {
		try {
			if (ClientOnSession.getLogged().getEmail()!=null) {
				loggedClient = ClientOnSession.getLogged();
				newTransaction.setDate(new Date());
				newTransaction.setType("Withdrawal");
				account = accountService.findByClient(loggedClient);
				double newBalance = account.getBalance() - newTransaction.getValue();
				if (newBalance < 0) {
					throw new IllegalArgumentException("Non-Sufficient Funds to cover this transaction. Your availible balance is $" + account.getBalance());
				}else {
					account.setBalance(newBalance);
					accountService.updateAccount(account);
					newTransaction.setAccount(account);
					transactionService.saveTransaction(newTransaction);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Access denied!");
		}
		throw new IllegalArgumentException("Access denied!");
	}

	
	
}
