package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class ThreadRingpuffer extends Ringpuffer {
	
	ThreadRingpuffer(int size) {
		super(size);
	}
	
	/**
	 * synchronized version of enter
	 * @param element object zu enter
	 * @throws OverflowException if ringbuffer is full
	 */
	public synchronized void put(Object element) throws InterruptedException{
		this.enter(element); 
		notifyAll();
	}
	
	/**
	 * synchronized version of leafe
	 * @return the object that leafes
	 * @throws UnderflowException if ringbuffer is empty
	 */
	public synchronized Object get() throws InterruptedException{
		Object ret = null;
		try {
			ret = this.leafe();
		} catch (UnderflowException e) {e.printStackTrace();}
		notifyAll();
		return ret;		
	}	
	
}
