package com.coding.task.models;

public class ClientOnSession {
	
	public static Client logged;

	public static Client getLogged() {
		return logged;
	}

	public static void setLogged(Client logged) {
		ClientOnSession.logged = logged;
	}
	
}
