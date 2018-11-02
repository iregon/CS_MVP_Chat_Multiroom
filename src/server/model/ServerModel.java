package server.model;

import java.util.ArrayList;

import server.users.User;

public class ServerModel {
	
	private ArrayList<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}
	
}
