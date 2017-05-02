package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class MyString implements Comparable{
	private String string;
	
	public MyString(String value){
		this.string = string;
	}
	
	public String getValue(){
		return string;
	}
	
	public int compareTo(Object other){
		return string.compareTo((String) other.toString());
	}


	
}
