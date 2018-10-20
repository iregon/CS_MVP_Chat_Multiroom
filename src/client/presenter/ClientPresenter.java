package client.presenter;

import general.Presenter;

public interface ClientPresenter extends Presenter {
	void sendMessageRequest(String msg);
	void setAddress(String addr);
}
