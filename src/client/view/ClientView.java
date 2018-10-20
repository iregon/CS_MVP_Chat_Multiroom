package client.view;

import client.presenter.ClientPresenter;
import general.MvpView;

public interface ClientView extends MvpView<ClientPresenter>{
	void appendMessage(String Message);
}
