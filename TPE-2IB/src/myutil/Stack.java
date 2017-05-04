package myutil;

public interface Stack {

	
	
	/**
	 * 
	 * @param element to put on stack
	 * @return Stack with element
	 */
	public Stack push(int element);
	
	
	/**
	 * Removes element on top of stack
	 * @return removed element
	 */
	public int pop();
	
	
	/**
	 * Get element on top of stack
	 * @return element on top of the stack
	 */
	public int top();
	
	
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
