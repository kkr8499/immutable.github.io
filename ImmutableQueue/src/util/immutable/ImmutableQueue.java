package util.immutable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImmutableQueue<T> implements ImmuteQueue<T>{
	final Queue<T> q;
	
	public ImmutableQueue() {
		q = new LinkedList<T>();
	}
	
	public ImmutableQueue(Queue<T> queue) {
		q = queue;
	}
	
	@Override
	public ImmuteQueue<T> enQueue(T t) {
		try {
			Queue<T> enqueue = new LinkedList<T>(q);
			enqueue.add(t);
			return new ImmutableQueue<T>(enqueue);
		}catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public ImmuteQueue<T> deQueue() throws NoSuchElementException{
		if(q.size() > 0) {
			Queue<T> dequeue = new LinkedList<T>(q);
			dequeue.remove();
			return new ImmutableQueue<T>(dequeue);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T head() {
		return q.peek();
	}

	@Override
	public boolean isEmpty() {
		
		if(q.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return q.size();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		if(q.size() > 0) {
			sb.append("[");
			Iterator<T> i = q.iterator();
			while(i.hasNext()) {			
				sb.append(i.next() + ",");
			}
			sb.append("]");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {		
		  if(obj==null) {
			  return false;
		  }
	      if (!(obj instanceof ImmutableQueue)) {
	    	  return false;
	      }	            
	       if (obj == this) {
	            return true;
	       }
	        return false;
	}
	
	@Override
	public int hashCode() {
		return q.hashCode();
	}
}

