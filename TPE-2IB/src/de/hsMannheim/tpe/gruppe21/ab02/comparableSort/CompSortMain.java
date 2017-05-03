package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

import static gdi.MakeItSimple.*;

public class CompSortMain {

	public static final boolean BUBBLESORT = true;
	public static final boolean INSERTSORT = false;
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	public static void printMyIntArray(MyInt[] toPrint){
		for(int i = 0; i < toPrint.length; i++){
			println(toPrint[i].getValue() + ", ");
		}
	}
	
	public static void printMyStringArray(MyString[] toPrint){
		for(int i = 0; i < toPrint.length; i++){
			println(toPrint[i].getValue() + ", ");
		}
	}

	public static Comparable[] sortArray(boolean sortType, Comparable[] sortArray){
		if(sortType = BUBBLESORT){
			return BubbleSort.bubbleSort(sortArray);
		}
		else{
			return InsertionSort.insertionSort(sortArray);
		}		
	}
	
	public static MyInt[] toMyInt(int[] intArray){
		MyInt[] myIntArray = new MyInt[intArray.length];
		for(int i = 0; i < intArray.length; i++){
			myIntArray[i] = new MyInt(intArray[i]);
		}
		return myIntArray;
	}
	
	public static MyString[] toMyString(String[] stringArray){
		MyString[] myStringArray = new MyString[stringArray.length];
		for(int i = 0; i < stringArray.length; i++){
			myStringArray[i] = new MyString(stringArray[i]);
		}
		return myStringArray;
	}
	
	
}
