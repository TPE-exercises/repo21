package de.hsMannheim.tpe.gruppe21.ab03.myutil;

public class OverflowException extends Exception{

	private static final long serialVersionUID = 5277594287287640867L;
	
	private Object objectCausedOverflow;
	
	public Object getObjectCausedOverflow(){
		return this.objectCausedOverflow;
	}
	
	public OverflowException(String message, Object objectCausedOverflow){
		super(message);
		this.objectCausedOverflow = objectCausedOverflow;
	}
	
	public String toString(){
		String mes = this.getMessage();
		mes += "\n Object Caused Overflow: " + objectCausedOverflow;
		return mes;
	}
}
