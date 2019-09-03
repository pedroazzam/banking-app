package com.coding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.task.models.Account;
import com.coding.task.models.Client;
import com.coding.task.models.ClientOnSession;
import com.coding.task.service.AccountService;
import com.coding.task.service.SecretKeyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="REST API - ACCOUNT")
@CrossOrigin(origins="*")
public class AccountController {
	
	Client loggedClient;
	Account account;
	
	@Autowired
	AccountService accountService;
	@Autowired
	SecretKeyService secretKeyService;
	
	
	@GetMapping("/account/all/{secretKey}")
	@ApiOperation(value="Return all accounts* [*ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER]")
	public List<Account> accountList(@PathVariable(value="secretKey") String secretKeyStr) {
		if(secretKeyService.existsByKey(secretKeyStr)) {
			return accountService.findAll();
		}
		throw new IllegalArgumentException("Access denied!");
	}
	
	@GetMapping("/account/myaccount")
	@ApiOperation(value="Return client's account balance")
	public Account account() throws Exception{
		try {
				ClientOnSession.getLogged().getEmail();
				loggedClient = ClientOnSession.getLogged();
				return accountService.findByClient(loggedClient);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Access denied!");
		}
		
	}
	
}
