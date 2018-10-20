package client;

import general.MvpView;

public interface ClientView extends MvpView<ClientPresenter>{
	void appendMessage(String Message);
}
