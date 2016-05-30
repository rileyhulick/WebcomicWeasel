package program;

import javax.swing.JOptionPane;

import interfaces.IErrorHandler;

public class ErrorHandler implements IErrorHandler {

	@Override
	public void onError(Exception e) {
		System.out.println(e.getClass().toString());
		System.out.println(e.getMessage());
		for (int i = 0; i < e.getStackTrace().length; i++)
			System.out.println(e.getStackTrace()[i].toString());
		
		JOptionPane.showMessageDialog(null, e.getClass().toString() + "\n"
				+ e.getMessage());
	}

}
