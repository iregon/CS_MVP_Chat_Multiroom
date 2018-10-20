package client;

import general.Presenter;

public interface ClientPresenter extends Presenter{
	void sendMessageRequest(String msg);
}
