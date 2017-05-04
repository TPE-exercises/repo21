package myutil;

public interface Queue {
	/**
	 * @param element to enter
	 * @return Queue with element
	 */
	public Queue enter(int element);
	
	/**
	 * work on first element
	 * @return Queue without first element
	 */
	public Queue leave();
	
	/**
	 * @return first element
	 */
	public int front();
	
	/**
	 * creates empty Queue
	 * @return empty Queue
	 */
	public Queue emptyList();
	
	/**
	 * @return true, if Queue is empty
	 * @return false, if Queue isn't empty
	 */
	public boolean isEmpty();
	
	/**
	 * @return Queue as String
	 */
	public String toString();
	
	/**
	 * 
	 * @return size of queue
	 */
	public int size();
}
