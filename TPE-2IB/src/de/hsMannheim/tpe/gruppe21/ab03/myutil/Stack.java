package de.hsMannheim.tpe.gruppe21.ab03.myutil;

public interface Stack {

	
	
	/**
	 * 
	 * @param element to put on stack
	 * @return Stack with element
	 * @throws OverflowException 
	 */
	public Stack push(Object element) throws OverflowException;
	
	
	/**
	 * Removes element on top of stack
	 * @return removed element
	 */
	public Object pop();
	
	
	/**
	 * Get element on top of stack
	 * @return element on top of the stack
	 */
	public Object top();
	
	
	/**
	 * Creates an empty stack
	 * @return empty stack
	 */
	public Stack empty();
	
	
	/**
	 * Checks if stack is empty
	 * @return true if stack is empty, false if not
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @return size of stack
	 */
	public int size();
	
}
