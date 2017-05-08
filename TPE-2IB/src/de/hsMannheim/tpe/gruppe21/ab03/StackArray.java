package de.hsMannheim.tpe.gruppe21.ab03;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.*;

public class StackArray implements Stack{

	private Object[] values;
	private int exceptionFlag = 0;
	
	
	StackArray(int size){
		this.values = new Object[size];
	}
	
	@Override
	public Stack push(Object element) throws OverflowException{
		try{
			if(values[values.length -1] != null){
				for(int i = 0; i < values.length; i++){
					if(values[i] == null){
						values[i] = element;
						break;
					}
				}
			}
			else{
				throw new OverflowException("Letztes Object im Array war nicht null" , element );
			}
		}catch(OverflowException oexc){
			if(exceptionFlag == 0){
				doublesSize();
			}
			else{
				throw oexc;
			}
		}
		
		return this;
	}
	
	private Object[] doublesSize(){
		Object[] doubled = new Object[this.values.length];
		for(int i = 0; i < this.values.length; i++){
			doubled[i] = values[i];
		}
		this.values = doubled;
		this.exceptionFlag++;
		return this.values;
	}
	

	@Override
	public Object pop() {
		try{
			if(values[0]== null){
				throw new UnderflowException("");
			}
		}catch(UnderflowException uexc){
			
		}
		
	}

	@Override
	public Object top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stack empty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
