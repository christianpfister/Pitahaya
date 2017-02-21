package ch.briggen.sparkbase;


/**
 * Unchecked Exception for unrecoverable things which happen during initialization
 * @author Marcel Briggen
 *
 */
public class ConfigurationException extends RuntimeException {

	/**
	 * Static UID
	 */
	private static final long serialVersionUID = -4020924360951332300L;
	
	/**
	 * 
	 * @param message Description
	 */
	public ConfigurationException(String message)
	{
		super(message);
	}
	
	/**
	 * 
	 * @param message Description
	 * @param emeddedException original Exception
	 */
	public ConfigurationException(String message, Throwable nestedException)
	{
		super(message,nestedException);
	}

}
