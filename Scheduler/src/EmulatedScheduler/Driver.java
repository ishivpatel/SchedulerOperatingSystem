package EmulatedScheduler;
import java.util.Random;
import java.util.Queue;

public class Driver {
	
	/**
	 * Runs the driver and calculates the elapsed time in nanoseconds for all scheduling activites.
	 * @param args - unused
	 * @throws TerminatedProcessException 
	 */
	public static void main(String[] args) throws TerminatedProcessException {
		
		Driver d = new Driver();
		long elapsed = d.run();
		
		if (elapsed == -1) {
			
			System.out.println("Your scheduler reported an error. Please check");
			
		} else {
			
			System.out.println("The elapsed time for the scheduler was " + elapsed + " nano seconds");
		}
		
	}
	
	/**
	 * Creates 100 process of a random run time time and places them in a queue.  We then send that queue to a 
	 * scheduler which schedulers the processes and runs them.
	 * @return The time it takes to run the scheduling of all processes.
	 * @throws TerminatedProcessException 
	 */
	public long run() throws TerminatedProcessException {
		
		long start = System.nanoTime(); // get current time
		Random r = new Random();
		
		Queue<Process> q = new Clock<Process>();
		
		for (int i=0; i < 100; i++) {
			
			Process p = new Process(r.nextInt(Integer.MAX_VALUE));
			q.offer(p);
			
		}
		
		Scheduler s = new Scheduler((Clock<Process>) q);
		
		return s.run() ? System.nanoTime() - start : -1;

		
	}

}