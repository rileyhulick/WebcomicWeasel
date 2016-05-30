package interfaces;

import layouts.LayoutDescription;

public interface IPagePresenter {
	public void createView() throws InstantiationException, IllegalAccessException;
	
	public void switchTo();
	
	public int getWidth();
	
	public int getHeight();
	
	public String getTitle();
	
	public LayoutDescription getLayout();
}
