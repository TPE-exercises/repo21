package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class MyInt implements Comparable {
	
	private int value;
	
	
	public MyInt(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public int compareTo(Object other){
		if(((MyInt)(other)).getValue() < this.getValue()){
			return 1;
		}
		else if(((MyInt)(other)).getValue() < this.getValue()){
			return 0;
		}
		else{
			return -1;
		}
	}
	
}
