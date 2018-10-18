package general;

public interface MvpView<TPresenter extends Presenter> extends View {
	void setPresenter(TPresenter presenter);
}
