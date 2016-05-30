package program;

public class Program {

	public static void main(String[] args) {
		
		wwcore.ProgramInstance programInstance;
		
		try {
		
			programInstance = new wwcore.ProgramInstance();
			
			programInstance.getRegistrar()
				.registerGeneralPurposePageView(GeneralPurposePageView.class);
			
			programInstance.getRegistrar()
				.registerViewSize(600, 800);
			programInstance.getRegistrar().registerErrorHandler(new ErrorHandler());
			
			programInstance.run();
			
		} catch (exceptions.LaunchTimeException e) {
			//Something went wrong while attempting to launch.
			System.out.println(e.getMessage());
		}
		
	}
}
