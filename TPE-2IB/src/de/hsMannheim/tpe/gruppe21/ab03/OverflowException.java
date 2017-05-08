package de.hsMannheim.tpe.gruppe21.ab03;

public class OverflowException extends Exception{

	private Object objectCausedOverflow;
	
	public Object getObjectCausedOverflow(){
		return this.objectCausedOverflow;
	}
	
	OverflowException(String message, Object objectCausedOverflow){
		super(message);
		this.objectCausedOverflow = objectCausedOverflow;
	}
	
	public String toString(){
		String mes = this.getMessage();
		mes += "\n Object Caused Overflow: " + Object;
		return mes;
	}
}
