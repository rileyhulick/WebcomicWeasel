package presenters;

import interfaces.IPagePresenter;
import interfaces.IPageView;
import wwcore.ServiceLocator;

//Superclass implementation for all other presenters
public abstract class PagePresenterBase implements IPagePresenter {

	@Override
	public void createView() throws InstantiationException, IllegalAccessException {
		
		if (ServiceLocator.getInstance().getPlatformRegistrar()
			.getViewRegistry().containsKey(this.getClass()))
			view = (IPageView) ServiceLocator.getInstance().getPlatformRegistrar()
				.getViewRegistry().get(this.getClass()).newInstance();
		else
			view = (IPageView) ServiceLocator.getInstance().getPlatformRegistrar()
					.getGeneralPurposePageView().newInstance();
		
		if (view == null)
			throw new RuntimeException("Failed to create view.");
		
		view.setPresenter(this);
	}

	@Override
	public void switchTo() {
		view.show();
	}
	
	public int getWidth() {
		return ServiceLocator.getInstance().getPlatformRegistrar()
				.getViewWidth();
	}
	
	public int getHeight() {
		return ServiceLocator.getInstance().getPlatformRegistrar()
				.getViewHeight();
	}
	
	protected IPageView view;
	

}
