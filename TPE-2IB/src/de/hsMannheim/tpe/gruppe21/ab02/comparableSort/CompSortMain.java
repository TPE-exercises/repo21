package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

import static gdi.MakeItSimple.*;

public class CompSortMain {

	public static final boolean BUBBLESORT = true;
	public static final boolean INSERTSORT = false;
	
	public static void main(String[] args) {
		String[] test1 = {"Hallo", "das", "ist", "nicht", "ausreichend", "getestet"};
		int[] test2 = {2,5,32,3,1,2,343,53,5,46,46};
		int[] test3 = {2,5,32,3,1,2,343,53,5,46,46};
		
		MyString[] testerTest1 = toMyString(test1);
		MyInt[] testerTest2 = toMyInt(test2);
		MyInt[] testerTest3 = toMyInt(test3);
		
		printMyStringArray(testerTest1);
		printMyIntArray(testerTest2);
		
		sortArray(INSERTSORT, testerTest1);
		sortArray(BUBBLESORT, testerTest2);
		sortArray(INSERTSORT, testerTest3);
		
		printMyStringArray(testerTest1);
		printMyIntArray(testerTest2);
		printMyIntArray(testerTest3);
		
	}
	
	
	public static void printMyIntArray(MyInt[] toPrint){
		for(int i = 0; i < toPrint.length; i++){
			print(toPrint[i].getValue() + ", ");
		}
		println();
	}
	
	public static void printMyStringArray(MyString[] toPrint){
		for(int i = 0; i < toPrint.length; i++){
			print(toPrint[i].getValue() + ", ");
		}
		println();
	}

	public static Comparable[] sortArray(boolean sortType, Comparable[] sortArray){
		if(sortType == BUBBLESORT){
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
