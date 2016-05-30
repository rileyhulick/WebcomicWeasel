package interfaces;

public interface IPageView {
	public void show();
	public void close();
	
	public void setPresenter(IPagePresenter presenter);
	
}
