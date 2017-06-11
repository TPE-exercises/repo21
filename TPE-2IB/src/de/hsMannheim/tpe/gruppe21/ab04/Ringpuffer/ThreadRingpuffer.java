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
		try {
			this.enter(element);
		} catch (OverflowException e) {e.printStackTrace();} 
		notifyAll();
	}
	
	/**
	 * synchronized version of leafe
	 * @return the object that leafes
	 * @throws UnderflowException if ringbuffer is empty
	 */
	public synchronized Object get() throws InterruptedException{
		notifyAll();
		try {
			return this.leafe();
		} catch (UnderflowException e) {e.printStackTrace();}
		return null;		
	}
	
	
}
