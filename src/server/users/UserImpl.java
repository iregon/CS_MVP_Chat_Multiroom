package server.users;

import java.net.Socket;

public class UserImpl implements User {
	
	private String name;
	private Socket socket;
	
	public UserImpl(String name, Socket socket) {
		this.name = name;
		this.socket = socket;
	}
}
