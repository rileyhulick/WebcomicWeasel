package exceptions;

//Exceptions which may be thrown while the program is
//launching, before the ProgramInstance.run() method is
//called. These are the only exceptions which should be
//exposed to the UI.
public class LaunchTimeException extends Exception {

	public LaunchTimeException(String message) {
		super(message);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3690515503492557719L;

}
