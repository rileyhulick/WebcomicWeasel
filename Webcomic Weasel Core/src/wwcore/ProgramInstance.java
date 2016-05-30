package wwcore;

import interfaces.IPagePresenter;
import presenters.MainPagePresenter;

public class ProgramInstance {
	
	public ProgramInstance() {
		registrar = new PlatformRegistrar();
	}
	
	public PlatformRegistrar getRegistrar(){
		return registrar;
	}
	
	public void run() {
		
		try {
			
			ServiceLocator.initialize(this);
			
			IPagePresenter mainPresenter = new MainPagePresenter();
			mainPresenter.createView();
			mainPresenter.switchTo();
			
		} catch (Exception e) {
			registrar.getErrorHandler().onError(e);
		}
	}
	
	private PlatformRegistrar registrar;
}
