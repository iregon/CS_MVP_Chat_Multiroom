package server;

import java.awt.Color;

import general.MvpView;
import general.Presenter;

public interface ServerView extends MvpView<Presenter> {
	void appendLog(String msg);
	void appendLog(String msg, Color color);
}
