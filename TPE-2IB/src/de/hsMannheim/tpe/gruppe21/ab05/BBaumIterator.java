package de.hsMannheim.tpe.gruppe21.ab05;

import java.util.Iterator;

public class BBaumIterator implements Iterator {

	private BTree bt;
	private Comparable value;
	
	BBaumIterator(BTree bt){
		this.bt = bt; 
		this.value = bt.getMin();
	}	
	
	@Override
	public boolean hasNext() {
		return (bt.getMax().compareTo(value) > 0);
	}

	@Override
	public Object next() {
		if(hasNext()){
			value = bt.getWurzel().next(value, false);
			return value;
		}
		else{
			System.out.println("Nothing next.");
		}
		return null;
	}

	@Override
	public void remove(){
		bt.delete(value);
		if(hasNext()){
			value = bt.getWurzel().next(value, false);
		}
		else{
			value = bt.getMax();
		}
	}
}
