package program;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import interfaces.IPagePresenter;
import interfaces.IPageView;

public abstract class PageViewBase implements IPageView {

	public PageViewBase() {
		frame = new JFrame(getTitle());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLayout(null);
        frame.setResizable(false);
        
	}

	public void setPresenter(IPagePresenter presenter) {
		if (this.presenter != presenter) {
			this.presenter = presenter;
			onPresenterSet();
			
			frame.setTitle(presenter.getTitle());
		}
	}
	
	public void show() {
		frame.setSize(presenter.getWidth(), presenter.getHeight());
        frame.setVisible(true);
	}
	
	public void close() {
		frame.dispose();
	}
	
	protected abstract void onPresenterSet();
	
	protected String getTitle() {
		if (presenter == null)
			return "Presenter not yet initialized";
		else
			return presenter.getTitle();
	}
	
	protected JFrame frame;
	protected IPagePresenter presenter;
	
	
}
