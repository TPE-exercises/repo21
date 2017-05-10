package de.hsMannheim.tpe.gruppe21.ab03;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.ADT;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.LinkedList;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.OverflowException;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.Queue;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.UnderflowException;

public class QueueLinkedList implements Queue, ADT {

	private int size;
	private LinkedList values;
	private int exceptionFlag = 0;
	
	public QueueLinkedList(int size){
		this.size = size;
		values = new LinkedList();
	}
	
	
	@Override
	public boolean enter(Object element) throws OverflowException {
		try{
			if(this.values.size()>= this.size){
				throw new OverflowException("List is full there is no place for: ", element);
			}
			else{
				this.values.addLast(element);
			}
		}catch(OverflowException oexc){
			if(exceptionFlag == 0){
				this.size *= 2;
				this.values.addLast(element);
				exceptionFlag++;
			}
			else{
				throw oexc;
			}
		}
		return true;
	}

	@Override
	public Object leave() throws UnderflowException {
		if(this.values.isEmpty()){
			throw new UnderflowException("Queue ist leer.");
		}
		else{
			Object elem = this.values.removeFirst();
			return elem;
		}
	}
	

	@Override
	public Object front() {
		return this.values.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return this.values.isEmpty();
	}

	@Override
	public int size() {
		return this.values.size();
	}

}
