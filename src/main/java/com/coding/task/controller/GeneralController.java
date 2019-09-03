package com.coding.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.task.models.Account;
import com.coding.task.models.Client;
import com.coding.task.models.ClientOnSession;
import com.coding.task.service.AccountService;
import com.coding.task.service.ClientService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api")
@ApiIgnore
public class GeneralController {
	
	Client loggedClient;
	
	@Autowired
	ClientService clientService;
	@Autowired
	AccountService accountService;
	
	
	@GetMapping("")
	public String initialEnter(Model model) {
		if (ClientOnSession.getLogged()==null) {
			ClientOnSession.setLogged(new Client());
		}
		loggedClient = ClientOnSession.getLogged();
		Client client = loggedClient;
		model.addAttribute("user", client);
		model.addAttribute("logInError", false);
		return "access-permit";
	}
	
	@PostMapping("/login-browser-check")
	public String getClient(Model newModel, @ModelAttribute("user") Client cliente) {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
		String email = cliente.getEmail();
		String password = cliente.getPassword();
		Client newClient = clientService.findByEmailAndPassword(email, password);
		if (newClient == null) {
			newModel.addAttribute("loginErrorCheck", true);
			return "access-permit";
		}else {
			loggedClient = newClient;
			newModel.addAttribute("user", newClient);
			ClientOnSession.setLogged(newClient);
			return "access-permit";
		}
	}
	
	@PostMapping("/logout-browser")
	public String signOut(Model newModel) {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
		newModel.addAttribute("user", loggedClient);
		return "access-permit";
	}
	
	@PostMapping("/signup-browser")
	public String signUpAsked(Model newModel) {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
		newModel.addAttribute("user", loggedClient);
		return "clients/signup";
	}
	
	@PostMapping("signup-browser-check")
	public String signUpCheck(Model newModel, @ModelAttribute("user") Client client) {
		loggedClient = new Client();
		ClientOnSession.setLogged(loggedClient);
		Client newClient = clientService.save(client);
		Account newAccount = new Account();
		newAccount.setBalance(0);
		newAccount.setClient(newClient);
		accountService.save(newAccount);
		newModel.addAttribute("user", loggedClient);
		return"access-permit";
	}
	


}
