package client.presenter;

import java.net.Socket;

import client.model.ClientModel;
import client.view.ClientView;
import configuration.Configuration;

public class ClientPresenterImpl implements ClientPresenter {

	private ClientView view;
	private ClientModel model;
	
	private String address = null;
	
	private Socket socket;
	
	public ClientPresenterImpl(ClientView view, ClientModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void sendMessageRequest(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public void setAddress(String addr) {
		this.address = addr;
		connectToServer();
	}

	private void connectToServer() {
		int port = Configuration.getInstance().getPort();
		try {
			socket = new Socket(address, port);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
