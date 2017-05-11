package de.hsMannheim.tpe.gruppe21.ab03;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.ADT;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.OverflowException;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.Queue;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.UnderflowException;

public class QueueArray implements Queue, ADT {

	private Object[] values;
	private int exceptionFlag = 0;
	private int inPointer;
	private int outPointer;

	QueueArray(int size) {
		this.values = new Object[size];
		this.inPointer = 0;
		this.outPointer = 0;
	}
	

	@Override
	public boolean enter(Object element) {
		try {
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
		} catch (OverflowException oexc) {
			if (exceptionFlag == 0) {
				this.doublesSize();
				this.values[inPointer] = element;
				this.inPointer++;
				this.exceptionFlag++;
			} else {
				this.inPointer = 0;
				this.values[this.inPointer] = element;
				if(this.outPointer == this.inPointer){
					this.outPointer++;
				}
				this.inPointer++;
				System.out.println(oexc.toString());
			}
		}
		return true;
	}

	private Object[] doublesSize() {
		Object[] doubled = new Object[(this.values.length * 2)];
		for (int i = 0; i < this.values.length; i++) {
			doubled[i] = values[i];
		}
		this.values = doubled;
		return this.values;
	}

	@Override
	public Object leave() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException("Queue is empty");
		} else {
			Object ret = this.values[this.outPointer];
			this.outPointer++;
			if(this.outPointer>= this.values.length){
				this.outPointer = 0;
			}
			return ret;

		}

	}

	@Override
	public Object front(){
		return values[outPointer]; 
		}
	

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < this.values.length; i++){
			if(this.values[i] != null){
				return false;
			}
		}
		return true;
	}

	@Override
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
