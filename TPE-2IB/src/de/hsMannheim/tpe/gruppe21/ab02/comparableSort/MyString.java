package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class MyString implements Comparable{
	private String value;
	
	public MyString(String value){
		this.value = value;
	}
	
	public int compareTo(MyString other){
		return -1;
	}
	
}
