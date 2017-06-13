package de.hsMannheim.tpe.gruppe21.ab05;

import java.io.*;

public class BTree implements BBaum {
	
	private int ordnung;
	private BBaumNode wurzel;
	
	BTree(int ordnung){
		this.ordnung = ordnung;
		wurzel = new BBaumNode(ordnung);
	}
	
	BTree(int ordnung, String filename){
		this(ordnung);
		try {
			insert(filename);
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht eingelesen werden");
		}
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
	public boolean insert(String filename) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
			
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {e.printStackTrace();}		
		return insertString(input);
	}

	public boolean insertString(String numberString){
		boolean temp = true;
		for(int i = 0; i < numberString.length(); i ++){
			if(numberString.charAt(i) == ' '){
				temp = temp && insert(Integer.parseInt(numberString.substring(0, i)));
				temp = temp && insertString(numberString.substring(i+1, numberString.length()));
				i = numberString.length();
			}
		}
		return temp;
	}
	
	@Override
	public boolean contains(Comparable o) {
		return wurzel.contains(o);
	}

	@Override
	public boolean delete(Comparable o) {
		if(this.contains(o)){
			boolean ret = wurzel.delete(o);
			BTree deletedBTree = new BTree(this.ordnung);
			this.wurzel.delete(o);
			deletedBTree.addAll(wurzel);
			this.wurzel = deletedBTree.wurzel;
			return ret;
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
		System.out.println("Inorder: ");
		wurzel.printInorder();
		System.out.println();
	}

	@Override
	public void printPostorder() {
		System.out.println("Postorder: ");
		wurzel.printPostorder();
		System.out.println();
	}

	@Override
	public void printPreorder() {
		System.out.println("Preorder: ");
		wurzel.printPreorder();
		System.out.println();	
	}

	@Override
	public void printLevelorder() {
		System.out.println("Levelorder: ");
		wurzel.printLevelorder();
		System.out.println();
	}
}


