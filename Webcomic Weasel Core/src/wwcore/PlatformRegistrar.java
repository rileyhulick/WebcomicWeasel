package wwcore;

import java.lang.Class;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import exceptions.LaunchTimeException;
import interfaces.IErrorHandler;
import interfaces.IPagePresenter;
import interfaces.IPageView;

//A service which tracks platform-specific information
//as supplied by the UI.
public class PlatformRegistrar {
	
	public PlatformRegistrar() {
		viewRegistry = new HashMap<Class<?>, Class<?>>();
		
	}
	
	public void registerViewClass(Class<?> presenter, 
			Class<?> view) throws LaunchTimeException {
		
		if (isSealed)
			throw new LaunchTimeException("The registrar is sealed. No new classes may be registered.");
		
		if(!IPagePresenter.class.isAssignableFrom(presenter)) {
			throw new LaunchTimeException(presenter.getName() + " does not implement IPresenter.");
		}
		if(!IPageView.class.isAssignableFrom(view)) {
			throw new LaunchTimeException(view.getName() + " does not implement IView.");
		}

		viewRegistry.put(presenter, view);
	}
	
	public void registerViewSize(int width, int height) throws LaunchTimeException {
		if (isSealed)
			throw new LaunchTimeException("The registrar is sealed. No new information may be registered.");
		
		viewWidth = width;
		viewHeight = height;
	}
	
	public void registerErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}
	
	public void registerGeneralPurposePageView(Class<?> pageView) {
		this.generalPurposePageView = pageView;
	}
	
	public void seal() throws LaunchTimeException {
		if (!isSealed)
			isSealed = true;
		else
			throw new LaunchTimeException("Registrar is already sealed");
	}
	
	public Map<Class<?> /* presenter */, Class<?> /* view */> getViewRegistry() {
		return Collections.unmodifiableMap(viewRegistry);
	}
	
	public int getViewWidth() {
		return viewWidth;
	}
	
	public int getViewHeight() {
		return viewHeight;
	}
	
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}
	
	public Class<?> getGeneralPurposePageView() {
		return generalPurposePageView;
	}
	
	private boolean isSealed = false;
	
	private Map<Class<?> /* presenter */, Class<?> /* view */> viewRegistry;
	
	private int viewWidth;
	private int viewHeight;
	
	private IErrorHandler errorHandler;
	
	private Class<?> generalPurposePageView;
	
}
