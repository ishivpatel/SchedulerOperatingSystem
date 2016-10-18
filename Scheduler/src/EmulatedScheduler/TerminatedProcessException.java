package EmulatedScheduler;
import java.lang.Exception;

/**
 * An exception that will get thrown if an emulated process tries to be run after it has been terminated
 * 
 * @author Professor McKee
 *
 */

public class TerminatedProcessException extends Exception {
	
	private static final long serialVersionUID = 5134772006006684605L;

	/**
	 * Only constructor needed. Uses the super class to pass an error message
	 * @param error - the error message to report
	 */
	public TerminatedProcessException(String error) {
		
		super(error);
		
	}

}
