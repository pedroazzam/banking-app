package com.coding.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.task.models.Account;
import com.coding.task.models.Client;
import com.coding.task.models.ClientOnSession;
import com.coding.task.service.AccountService;
import com.coding.task.service.ClientService;
import com.coding.task.service.SecretKeyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="REST API - CLIENT")
@CrossOrigin(origins="*")
public class ClientController {
	

	public Client loggedClient;

	
	@Autowired
	ClientService clientService;
	@Autowired
	AccountService accountService;
	@Autowired
	SecretKeyService secretKeyService;
	
	
	@GetMapping("/client/all/{secretKey}")
	@ApiOperation(value="Return all clients* [*ONLY ALLOWED PASSING THE SECRET KEY AS PARAMETER]")
	public List<Client> clientList(@PathVariable(value="secretKey") String secretKeyStr) {
		if (secretKeyService.existsByKey(secretKeyStr)){
			return clientService.findAll();
		}
		throw new IllegalArgumentException("Access denied!");
	}
	
	@GetMapping("/myprofile")
	@ApiOperation(value="Return client's profile")
	public Client clientProfile() {
		try {
			if(ClientOnSession.getLogged().getEmail()!=null) {
				loggedClient = ClientOnSession.getLogged();
				long id = loggedClient.getId();
				return clientService.findById(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Access denied!");
		}
		throw new IllegalArgumentException("Access denied!");
	}
	
	@PostMapping("/logout")
	@ApiOperation(value="Client ends session")
	public void signOut() {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
	}
	
	@PostMapping("/signup")
	@ApiOperation(value="Register a client")
	public Client saveClient(@RequestBody Client client) {
		Client newClient = clientService.save(client);
		Account newAccount = new Account();
		newAccount.setBalance(0);
		newAccount.setClient(newClient);
		accountService.save(newAccount);
		return newClient;
	}
	
	@PostMapping("/login")
	@ApiOperation(value="Client initiate session")
	public Client getLoggedIn(Model newModel, @RequestBody Client clientBody) {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
		String email = clientBody.getEmail();
		String password = clientBody.getPassword();
		
		Client newClient = clientService.findByEmailAndPassword(email, password);
		
		if (newClient != null) {
			loggedClient = newClient;
			ClientOnSession.setLogged(newClient);
			return newClient;
		}else {
			throw new IllegalArgumentException("Access denied! Please try again or SignUp.");
		}
		
	}

}
