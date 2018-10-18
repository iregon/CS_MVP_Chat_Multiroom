package general;

public abstract class BaseView<T extends Presenter> implements View {

	protected T presenter;
	
	@Override
	public abstract void render();
	
	public void setPresenter(T presenter) {
		this.presenter = presenter;
	}
}
