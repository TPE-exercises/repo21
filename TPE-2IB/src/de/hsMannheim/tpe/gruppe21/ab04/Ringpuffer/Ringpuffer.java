package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class Ringpuffer {
	private Object[] values;
	private int inPointer;
	private int outPointer;

	Ringpuffer(int size) {
		this.values = new Object[size];
		this.inPointer = 0;
		this.outPointer = 0;
	}
	
	/**
	 * enters element in ringbuffer
	 * @param element object zu enter
	 * @throws OverflowException if ringbuffer is full
	 */
	public synchronized void enter(Object element) throws OverflowException {
		if(inPointer >= this.values.length){
			throw new OverflowException("inPointer ist übergelaufen", element);
		}
		else{
			this.values[inPointer] = element;
			if(this.inPointer == this.outPointer){
				this.outPointer++;
				if(this.outPointer >= this.values.length){
					this.outPointer = 0;
				}
			}
			this.inPointer ++;
		} 
	}

	/**
	 * one Object leafes thr ringbuffer
	 * @return the object that leafes
	 * @throws UnderflowException if ringbuffer is empty
	 */
	public synchronized Object leafe() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException("Ringbuffer is empty");
		} else {
			
			Object ret = this.values[this.outPointer];
			this.outPointer++;
			if(this.outPointer>= this.values.length){
				this.outPointer = 0;
			}
			return ret;
		}
	}

	/**
	 * @return front element
	 */
	public Object front(){
		return values[outPointer]; 
	}
	
	/**
	 * @return true if ringbuffer is empty
	 */
	public boolean isEmpty() {
		for(int i = 0; i < this.values.length; i++){
			if(this.values[i] != null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return true if ringbuffer is full
	 */
	public boolean isFull(){
		for(int i = 0; i< values.length; i++){
			if(values[i] == null){
				return false;
			}
		}
		return true;
	}

	/**
	 * @return size of ringbuffer
	 */
	public int size() {
		int size = 0;
		for(int i = 0; i < values.length; i++){
			if(values[i] != null){
				size++;
			}
		}
		return size;
	}
}
