package EmulatedScheduler;

public class Node {
	private Process process;
	private Node next;

	public Node()
	{
		process = null;
		next = this;
	}
	

	public Node(Process arg0)
	{
		this.process = arg0;
		this.next = null;
	}

	public Node(Process process, Node next)
	{
		this.process = process;
		this.next = next;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Process getProcess()
	{
		return process;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public void setProcess(Process process)
	{
		this.process = process;
	}

}
