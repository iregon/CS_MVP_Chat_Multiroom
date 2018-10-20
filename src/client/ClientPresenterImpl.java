package client;

public class ClientPresenterImpl implements ClientPresenter {

	private ClientView view;
	private ClientModel model;
	
	public ClientPresenterImpl(ClientView view, ClientModel model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void sendMessageRequest(String msg) {
		System.out.println(msg);
	}
	
}
