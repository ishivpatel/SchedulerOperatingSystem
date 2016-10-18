package EmulatedScheduler;

/**
 * An emulated process class.
 * @author Patrick
 *
 */
public class Process {
	
	private int timeToRun;
	
	/**
	 * Single constructor - an integer that will hold an emulated time period for which to run.
	 * @param timeToRun The amount of time this process needs to complete.
	 */
	public Process(int timeToRun) {
	
		this.timeToRun = timeToRun;
	}
	
	/**
	 * Accessor method to retrieve the time needed for the process to compute.
	 * @return
	 */
	public int getTimeToRun() {
		
		return timeToRun;
		
	}
	
	/**
	 * The emulated run of a process.  Simply subtracts from the quantum from the time to run one int at a time.
	 * @param quantum - The emulated time to run that will be subtracted from the timeToRun
	 * @throws TerminatedProcessException - is thrown if a process is ran with a timeToRun of 0
	 */
	public void run(int quantum) throws TerminatedProcessException {
		
		if (timeToRun < 0) {
			
			throw new TerminatedProcessException("Process has been terminated");
			
		}
		
		for (int i=0; i < quantum && timeToRun > 0; i++) {
			
			timeToRun--;
			
		}
	
	}
	
	

}
