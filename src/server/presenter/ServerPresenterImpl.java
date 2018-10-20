package server.presenter;

import server.model.ServerModel;
import server.view.ServerView;

public class ServerPresenterImpl implements ServerPresenter {
	
	private ServerView view;
	private ServerModel model;
	
	public ServerPresenterImpl(ServerView view, ServerModel model) {
		this.view = view;
		this.model = model;
	}
}
