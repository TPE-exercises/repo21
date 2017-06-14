package de.hsMannheim.tpe.gruppe21.ab05;

import java.util.Iterator;

public class BBaumIterator implements Iterator {

	private BTree bt;
	private Comparable value;
	
	BBaumIterator(BTree bt){
		this.bt = bt; 
		this.value = bt.getMin();
	}	
	
	public Comparable getValue(){
		return this.value;
	}
	
	@Override
	public boolean hasNext(){
		if(value == null){
			return false;
		}
		return (bt.getMax().compareTo(value) > 0);
	}

	@Override
	public Object next() {
		if(hasNext()){
			value = bt.getWurzel().next(value);
			return value;
		}
		else{
			System.out.println("Nothing next.");
		}
		return null;
	}

	@Override
	public void remove(){
		if(value == null){
			System.out.println("Nothing to remove.");
			return;
		}
		Comparable safer = value;
		boolean hadNext;
		if(hasNext()){
			value = bt.getWurzel().next(value);
			hadNext = true;
		}
		else{
			hadNext = false;
		}
		bt.delete(safer);
		System.out.println("Removed: " + safer);
		if(!hadNext){
			value = bt.getMax();
		}
		
	}
}
