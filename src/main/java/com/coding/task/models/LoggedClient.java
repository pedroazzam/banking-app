package com.coding.task.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoggedClient {
	Client loggedClient;

	public Client getLoggedClient() {
		return loggedClient;
	}

	public void setLoggedClient(Client loggedClient) {
		this.loggedClient = loggedClient;
	}
	
}
