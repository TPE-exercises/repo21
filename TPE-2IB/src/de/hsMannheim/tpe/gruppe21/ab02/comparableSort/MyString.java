package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class MyString implements Comparable{
	private String value;
	
	public MyString(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public int compareTo(Object other){
		return value.compareTo((String) other.toString());
	}


	
}
