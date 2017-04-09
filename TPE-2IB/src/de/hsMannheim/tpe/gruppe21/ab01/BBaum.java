package de.hsMannheim.tpe.gruppe21.ab01;

public interface BBaum {
	/**
	 * @param int, to insert
	 * @return boolean, true if insertion was successful
	 */
	boolean insert (Integer o);
	
	/**
	 * @param filename of file to insert
	 * @return boolean, true if insertion was successful
	 */
	boolean insert (String filename);
	
	/**
	 * @param the int to search
	 * @return boolean, true if int is contained
	 */
	boolean contains (Integer o);
	
	/**
	 * @return int, size of tree
	 */
	int size();
	
	/**
	 * @return int, height of the tree
	 */
	int height();
	
	/**
	 * @return int, max value contained by tree
	 */
	Integer getMax();
	
	/**
	 * @return int, min value contained by tree
	 */
	Integer getMin();
	
	/**
	 * @return boolean, true if tree is empty
	 */
	boolean isEmpty();
	
	/**
	 * @param BTree, insert otherTree this
	 */
	void addAll(BTree otherTree);
	
	/**
	 * prints this Tree on console inorder
	 */
	void printInorder();
	
	/**
	 * prints this Tree on console postorder
	 */
	void printPostorder();
	
	/**
	 * prints this Tree on console preorder
	 */
	void printPreorder();
	
	/**
	 * prints this Tree on console levelorder
	 */
	void printLevelorder();
}
