package general;

public abstract class MvpViewAbstract<TPresenter extends Presenter> implements MvpView<TPresenter>{
	
	protected TPresenter presenter;
	
	@Override
	public void setPresenter(TPresenter presenter) {
		this.presenter = presenter;
	}
	
}
