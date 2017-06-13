package de.hsMannheim.tpe.gruppe21.ab05;

import static gdi.MakeItSimple.*;

public class BTree implements BBaum {
	
	private int ordnung;
	private BBaumNode wurzel;
	
	BTree(int ordnung){
		this.ordnung = ordnung;
		wurzel = new BBaumNode(ordnung);
	}
	
	BTree(int ordnung, String filename){
		this(ordnung);
		if(!insert(filename))
			throw new GDIException("Datei konnte nicht eingelesen werden");
	}
	
	public BBaumNode getWurzel(){
		return wurzel;
	}
	
	@Override
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
		
	@Override
	public boolean insert(String filename) {
		Object file = openInputFile(filename);
		boolean temp = true;
		while (!isEndOfInputFile(file)) {
			temp = insert(readInt(file)) && temp;
		}
		closeInputFile(file);
		return temp;
	}

	@Override
	public boolean contains(Comparable o) {
		return wurzel.contains(o);
	}

	@Override
	public boolean delete(Comparable o) {
		if(this.contains(o)){
			return wurzel.delete(o);
		}
		return false;
	}
	
	@Override
	public int size() {
		return wurzel.getSize();
	}

	@Override
	public int height() {
		if(isEmpty()){
			return 0;
		}
		else
			return wurzel.height();
	}

	@Override
	public Comparable getMax() {
		return wurzel.getMax();
	}

	@Override
	public Comparable getMin() {
		return wurzel.getMin();
	}

	@Override
	public boolean isEmpty() {
		if(wurzel == null || wurzel.getValues()[0]==null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
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

	@Override
	public void printInorder() {
		println("Inorder: ");
		wurzel.printInorder();
		println();
	}

	@Override
	public void printPostorder() {
		println("Postorder: ");
		wurzel.printPostorder();
		println();
	}

	@Override
	public void printPreorder() {
		println("Preorder: ");
		wurzel.printPreorder();
		println();	
	}

	@Override
	public void printLevelorder() {
		println("Levelorder: ");
		wurzel.printLevelorder();
		println();
	}
}


