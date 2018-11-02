package server.presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import configuration.Configuration;
import server.model.ServerModel;
import server.thread.Program;
import server.users.User;
import server.users.UserImpl;
import server.view.ServerView;

public class ServerPresenterImpl implements ServerPresenter {
	
	private ServerView view;
	private ServerModel model;
	
	private ServerSocket serverSocket;
	
	public ServerPresenterImpl(ServerView view, ServerModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void startServerSocket() {
		int port = Configuration.getInstance().getPort();
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.appendLog(">>> Server avviato\n");
		startConnectionHandler();
	}
	
	private void startConnectionHandler() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				Thread thread = new Thread(new Program(socket));
				User newUser = new UserImpl(null, socket);
				model.addUser(newUser);
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
