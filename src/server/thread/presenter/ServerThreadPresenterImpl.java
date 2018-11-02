package server.thread.presenter;

import java.net.Socket;

import server.thread.model.ServerThreadModel;

public class ServerThreadPresenterImpl implements ServerThreadPresenter {
	
	private ServerThreadModel model;
	private Socket socket;

	public ServerThreadPresenterImpl(ServerThreadModel model, Socket socket) {
		this.model = model;
		this.socket = socket;
	}
}
