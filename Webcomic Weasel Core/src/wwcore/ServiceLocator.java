package wwcore;

public class ServiceLocator {
	
	private ServiceLocator() {
	}
	
	static void initialize(ProgramInstance programInstance) {
		if (instance != null) {
			throw new RuntimeException("Attempted to initialize ServiceLocator that was already initialized.");
		}
		
		instance = new ServiceLocator();
		
		ServiceLocator.programInstance = programInstance;
	}
	
	public static ServiceLocator getInstance() {
		return instance;
	}
	
	public PlatformRegistrar getPlatformRegistrar() {
		return programInstance.getRegistrar();
	}
	
	private static ServiceLocator instance;
	
	private static ProgramInstance programInstance;
}
