package client;

import general.MvpView;
import general.View;

public interface ClientView extends MvpView<ClientPresenter>{
	void appendMessage(String Message);
	
//	interface ClientViewEventListener {
//        void loginButtonClicked(String username, String password);
//    }
}
