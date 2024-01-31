package mainApp;
/**
 * Custom exception class that is responsible for handling exceptions
 */
public class InvalidLevelFormatException extends Exception {

	public InvalidLevelFormatException(String message) {
        super(message);
    }
	
}
