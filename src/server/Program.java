package server;

public class Program {
	public static void main(String[] args) {
		ServerView startingView = new SwingServerView();
		ServerPresenter presenter = new ServerPresenterImpl(startingView, null);
		startingView.setPresenter(presenter);
		startingView.render();
	}
}
