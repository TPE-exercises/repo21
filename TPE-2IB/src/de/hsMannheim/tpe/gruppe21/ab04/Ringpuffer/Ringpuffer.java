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
	
	public void put(Object element) throws OverflowException {
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

	public Object get() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException("Ringbuffer is empty");
		} else {
			
			System.out.println("Out Pointer : " + this.outPointer);
			System.out.println("Out Pointer Object: "+ values[outPointer]);
			
			Object ret = this.values[this.outPointer];
			this.outPointer++;
			if(this.outPointer>= this.values.length){
				this.outPointer = 0;
			}
			return ret;
		}
	}

	public Object front(){
		return values[outPointer]; 
	}
	
	public boolean isEmpty() {
		for(int i = 0; i < this.values.length; i++){
			if(this.values[i] != null){
				return false;
			}
		}
		return true;
	}

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
