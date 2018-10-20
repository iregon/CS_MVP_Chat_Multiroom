package server.view;

import java.awt.Color;

import general.MvpView;
import general.Presenter;
import server.presenter.ServerPresenter;

public interface ServerView extends MvpView<ServerPresenter> {
	void appendLog(String msg);
	void appendLog(String msg, Color color);
}
