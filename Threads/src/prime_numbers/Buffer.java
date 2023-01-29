package prime_numbers;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	int size;
	
	boolean producer_finish = false;
	Queue<String> buffer = new LinkedList<String>();
	
	public Buffer(int size) {
		this.size = size;
	}
	public boolean emptyBuffer() {
		if(buffer.size() == 0)
			return true;
		else
			return false;
	}
	 public void producerFinish() {
		 this.producer_finish = true;
	 }
	 public synchronized void addElement(String element) throws InterruptedException {
		 while(buffer.size() == size) {
			 wait();
		 }
		 buffer.add(element);
		 notify();
	 }
	 public synchronized String consume() throws InterruptedException {
		 while(buffer.size() == 0) {
			 wait();
		 }
		 String element = buffer.remove();
		 notify();
		 return element;
	 }
}
