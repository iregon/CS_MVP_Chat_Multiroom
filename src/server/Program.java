package server;

import server.presenter.ServerPresenter;
import server.presenter.ServerPresenterImpl;
import server.view.ServerView;
import server.view.SwingServerView;
import utils.ServerViewLogManager;

public class Program {
	public static void main(String[] args) {
		ServerView startingView = new SwingServerView();
		ServerPresenter presenter = new ServerPresenterImpl(startingView, null);
//		ServerViewLogManager.getInstance().setServerView(startingView);
		startingView.setPresenter(presenter);
		startingView.render();
	}
}
