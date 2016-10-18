package EmulatedScheduler;



public class Scheduler {

	private Clock clock; 

	
	public Scheduler(Clock<Process> q) {
		this.clock = q;
	}
	
	
	public boolean run() throws TerminatedProcessException {
		while (!clock.isEmpty()) {
			if (clock.getHead().getProcess().getTimeToRun() <= 0) {
				clock.remove();
			} else {
				clock.getHead().getProcess().run(10);
				if (clock.getHead().getProcess().getTimeToRun() > 0){
					Node temp = clock.getHead();
					clock.remove();
					clock.add(temp);
				}
			}
		}
		return true;
	}
}