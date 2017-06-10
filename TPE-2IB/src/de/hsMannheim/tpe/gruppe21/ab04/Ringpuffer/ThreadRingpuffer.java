package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class ThreadRingpuffer extends Ringpuffer {
	
	ThreadRingpuffer(int size) {
		super(size);
	}
	
	@Override
	public synchronized void put(Object element) throws OverflowException{
		super.put(element);
	}
	
	@Override
	public synchronized Object get() throws UnderflowException{
		return super.get();
	}
}
