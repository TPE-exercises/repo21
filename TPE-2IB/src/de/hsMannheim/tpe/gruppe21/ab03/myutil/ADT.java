package de.hsMannheim.tpe.gruppe21.ab03.myutil;

public interface ADT {
	/**
	 * if queue is full for the first time, size gets doubled, else overflow exception
	 * @param element to enter
	 * @return Queue with element
	 *  @throws OverflowException 
	 */
	public boolean enter(Object element) throws OverflowException;;
	
	/**
	 * Removes first element of queue
	 * @return first element
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * @return first element of Queue
	 */
	public Object front();
	
	
	/**
	 * @return true, if Queue is empty
	 * @return false, if Queue isn't empty
	 */
	public boolean isEmpty();
	
	
	/**
	 * 
	 * @return size of queue
	 */
	public int size();
}

