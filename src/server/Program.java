package server;

import server.presenter.ServerPresenter;
import server.presenter.ServerPresenterImpl;
import server.view.ServerView;
import server.view.SwingServerView;

public class Program {
	public static void main(String[] args) {
		ServerView startingView = new SwingServerView();
		ServerPresenter presenter = new ServerPresenterImpl(startingView, null);
		startingView.setPresenter(presenter);
		startingView.render();
	}
}
