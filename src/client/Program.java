package client;

public class Program {
	
	public static void main(String[] args) {
		ClientView startingView = new SwingClientView();
		ClientPresenter presenter = new ClientPresenterImpl(startingView, null);
		startingView.setPresenter(presenter);
		startingView.render();
	}
}
