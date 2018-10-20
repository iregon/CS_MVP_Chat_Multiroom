package client;

import client.presenter.ClientPresenter;
import client.presenter.ClientPresenterImpl;
import client.view.ClientView;
import client.view.SwingClientView;

public class Program {
	
	public static void main(String[] args) {
		ClientView startingView = new SwingClientView();
		ClientPresenter presenter = new ClientPresenterImpl(startingView, null);
		startingView.setPresenter(presenter);
		startingView.render();
	}
}
