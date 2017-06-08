package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class UnderflowException extends Exception{

	private static final long serialVersionUID = -3612283240367057825L;

	public UnderflowException(String message){
		super(message);
	}
}
