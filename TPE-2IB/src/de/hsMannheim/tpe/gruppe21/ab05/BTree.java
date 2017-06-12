package de.hsMannheim.tpe.gruppe21.ab05;

import static gdi.MakeItSimple.*;

public class BTree implements BBaum {
	
	//Attribute
	private int ordnung;
	private BBaumNode wurzel;
	
	//Konstruktoren
	BTree(int ordnung){
		this.ordnung = ordnung;
		wurzel = new BBaumNode(ordnung);
	}
	
	BTree(int ordnung, String filename){
		this(ordnung);
		if(!insert(filename))
			throw new GDIException("Datei konnte nicht eingelesen werden");
	}
	
	
	//Methoden
	public BBaumNode getWurzel(){
		return wurzel;
	}
	
	/**
	 * @param o Integer to insert in BTree
	 * @return True if it worked, false if doesnt
	 */
	public boolean insert(Comparable o) {
		Comparable ins = o;
		if(contains(ins)){
			return false;
		}
		//dummy gets transfered, if there was o parent before, and burst() gets executed, dummy becomes new root
		BBaumNode dummy = new BBaumNode(this.ordnung);
		boolean temp = wurzel.insert(ins,false,dummy);
		if(dummy.getValues()[0] != null){
			wurzel = dummy;
		}
		return temp;
	}
		
	/**
	 * @param filename File to get inserted
	 * @return true if everythin was succesfull, else false
	 */
	public boolean insert(String filename) {
		Object file = openInputFile(filename);
		boolean temp = true;
		while (!isEndOfInputFile(file)) {
			temp = insert(readInt(file)) && temp;
		}
		closeInputFile(file);
		return temp;
	}

	/**
	 * @param o Integer to search
	 * @return true, if o is in the Tree, else false
	 */
	public boolean contains(Comparable o) {
		Comparable ins = o;
		return wurzel.contains(ins);
	}

	/**
	 * @return amount of values in Tree
	 */
	public int size() {
		return wurzel.getSize();
	}

	/**
	 * @return height of Tree
	 */
	public int height() {
		if(isEmpty()){
			return 0;
		}
		else
			return wurzel.height();
	}

	/**
	 * @return max Value of Tree
	 */
	public Comparable getMax() {
		return wurzel.getMax();
	}

	/**
	 * @return min Value of Tree
	 */
	public Comparable getMin() {
		return wurzel.getMin();
	}

	/**
	 * @return true, if Tree is empty, else false
	 */
	public boolean isEmpty() {
		if(wurzel == null || wurzel.getValues()[0]==null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * like printInorder, but instead of printing, it adds the values to this tree
	 * @param otherTree inserts everything of other tree
	 */
	public void addAll(BTree otherTree) {
		addAll(otherTree.wurzel);
	}
	/**
	 * adds every value of otherTree to this
	 * @param otherNode to get insert
	 */
	public void addAll(BBaumNode otherNode) {
		for(int i = 0; i < otherNode.getPointer().length; i++){
			if(otherNode.getPointer()[i]!=null){
				addAll(otherNode.getPointer()[i]);
			}
			if(i < otherNode.getValues().length && otherNode.getValues()[i]!=null){
				insert(otherNode.getValues()[i]);
			}
		}
		
	}

	/**
	 * prints Tree Inorder	
	 */
	public void printInorder() {
		println("Inorder: ");
		wurzel.printInorder();
		println();
	}

	/**
	 * prints Tree Postorder	
	 */
	public void printPostorder() {
		println("Postorder: ");
		wurzel.printPostorder();
		println();
	}

	/**
	 * prints Tree Preorder	
	 * 
	 */
	public void printPreorder() {
		println("Preorder: ");
		wurzel.printPreorder();
		println();	
	}

	/**
	 * prints Tree Levelorder	
	 */
	public void printLevelorder() {
		println("Levelorder: ");
		wurzel.printLevelorder();
		println();
	}



}


