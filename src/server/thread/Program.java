package server.thread;

import java.net.Socket;

import server.thread.model.ServerThreadModel;
import server.thread.presenter.ServerThreadPresenter;
import server.thread.presenter.ServerThreadPresenterImpl;

public class Program implements Runnable{
	
	private Socket socket;
	
	public Program(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		ServerThreadModel model = new ServerThreadModel();
		ServerThreadPresenter presenter = new ServerThreadPresenterImpl(model, socket);
	}
}
