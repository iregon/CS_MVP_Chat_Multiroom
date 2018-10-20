package server.presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import configuration.Configuration;
import server.model.ServerModel;
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
		view.appendLog(">>> Server avviato");
		startConnectionHandler();
	}
	
	private void startConnectionHandler() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
