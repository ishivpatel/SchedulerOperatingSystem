package EmulatedScheduler;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Clock<Process> implements Queue<Process> {

	public Node head;
	public Node tail;
	public int totalNodes;

	public Clock()
	{
		
		head = null;
		tail = null;
		totalNodes = 0;
	}
	

	@Override
	public boolean offer(Process arg0) {
		totalNodes++;
		Node tempNode = new Node((EmulatedScheduler.Process) arg0);
		if(head == null)
		{
			head = tempNode;
			tail = tempNode;
			head.setNext(tail);
			tail.setNext(head);
		}
		else
		{
			tail.setNext(tempNode);
			tail = tail.getNext();
			tail.setNext(head);
		}
		return true;
	}


	public Process remove() {
		if(totalNodes > 1)
		{
			Node temp = head;
			head = head.getNext();
			tail.setNext(head);
			totalNodes--;
			return (Process) temp.getProcess();
		}
		else 
		{
			tail = null;
			head = null;
			totalNodes = 0;
			return null;
		}
	}

	@Override
	public boolean removeAll(Collection arg0) {
		this.head = null;
		totalNodes = 0;
		return true;
		
	}

	@Override
	public boolean add(Object arg0) {
		totalNodes++;
		if(head == null)
		{
			head = (Node) arg0;
		}
		else
		{
			tail.setNext((Node) arg0);
			tail = tail.getNext();
			tail.setNext(head);
		}
		return true;
	}

	public Node getHead()
	{
		return head;
	}


	public Node getTail()
	{
		return tail;
	}
	
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	
	public int getElements()
	{
		return totalNodes;
	}

	@Override
	public Process element() {
		return (Process) head.getProcess();
	}

	@Override
	public boolean remove(Object arg0) {
		if(totalNodes > 1)
		{
			head = head.getNext();
			tail.setNext(head);
			totalNodes--;
			System.out.println(totalNodes);
			return true;
		}
		else
		{
			tail = null;
			head = null;
			totalNodes = 0;
			System.out.println("ele reset to 0");
			return true;
		}
	}
	
	@Override
	public int size() {
		return totalNodes;
	}

	@Override
	public void clear() {
		this.removeAll(this);
		
	}

	public boolean addAll(Collection arg0) {
		
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Process peek() {
		// TODO Auto-generated method stub
		return (Process) this.head;
	}

	@Override
	public Process poll() {
		// TODO Auto-generated method stub
		return null;
	}

}