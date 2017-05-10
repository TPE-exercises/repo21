package de.hsMannheim.tpe.gruppe21.ab03;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.ADT;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.OverflowException;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.Queue;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.UnderflowException;

public class QueueArray implements Queue, ADT {

	private Object[] values;
	private int exceptionFlag = 0;

	QueueArray(int size) {
		this.values = new Object[size];
	}
	

	@Override
	public boolean enter(Object element) throws OverflowException {
		try {
			if (values[values.length - 1] == null) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] == null) {
						values[i] = element;
						break;
					}
				}
			} else {
				throw new OverflowException("Queue is full there is no place for: ", element);
			}
		} catch (OverflowException oexc) {
			if (exceptionFlag == 0) {
				doublesSize(element);
				this.exceptionFlag++;
			} else {
				throw oexc;
			}
		}

		return true;
	}

	private Object[] doublesSize(Object element) {
		Object[] doubled = new Object[(this.values.length * 2)];
		for (int i = 0; i < this.values.length; i++) {
			doubled[i] = values[i];
		}
		doubled[this.values.length] = element;
		this.values = doubled;
		return this.values;
	}

	@Override
	public Object leave() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException("Queue is empty");
		} else {
			Object ret = new Object();
			ret = values[0];
			Object leavedArray[] = new Object[this.values.length];
			for (int i = 0; i < values.length - 1; i++) {
				if (values[i + 1] == null) {
					break;
				}
				leavedArray[i] = values[i + 1];
			}
			this.values = leavedArray;
			return ret;

		}

	}

	@Override
	public Object front(){
		return values[0]; 
		}
	

	@Override
	public boolean isEmpty() {
		if (values[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		for(int i = 0; i < values.length; i++){
			if(values[i] == null){
				return i;
			}
		}
		return values.length;
	}

}
