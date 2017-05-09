package de.hsMannheim.tpe.gruppe21.ab03;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.*;

public class StackLinkedList implements Stack {

	private int size;
	private LinkedList values;
	private int exceptionFlag = 0;
	
	public StackLinkedList(int size){
		this.size = size;
	}
	
	@Override
	public Stack push(Object element) throws OverflowException {
		try{
			if(this.values.size()>= this.size){
				throw new OverflowException("Maximale Groesse dieser Liste(" + this.size + ") erreicht.", element);
			}
			else{
				this.values.addLast(element);
				this.size = this.values.size();
			}
		}catch(OverflowException oexc){
			if(exceptionFlag == 0){
				this.size *= 2;
				this.values.addLast(element);
				this.size = this.values.size();
			}
			else{
				throw oexc;
			}
		}
		return this;
	}

	@Override
	public Object pop() throws UnderflowException {
		if(this.values.isEmpty()){
			throw new UnderflowException("Stack ist leer.");
		}
		else{
			Object elem = this.values.removeLast();
			return elem;
		}
	}

	@Override
	public Object top() {
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
