package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class ThreadRingpuffer extends Ringpuffer {
	
	ThreadRingpuffer(int size) {
		super(size);
	}
	
	public synchronized void put(Object element) throws InterruptedException{
		if(this.isFull()){
			wait();
		}
		try {
			this.enter(element);
		} catch (OverflowException e) {	e.printStackTrace();} 
		notifyAll();
	}
	
	public synchronized Object get() throws InterruptedException{
		while(this.isEmpty()){
			wait();
		}
		try {
			return this.leafe();
		} catch (UnderflowException e) {e.printStackTrace();}
		return null;		
	}
	
	
}
