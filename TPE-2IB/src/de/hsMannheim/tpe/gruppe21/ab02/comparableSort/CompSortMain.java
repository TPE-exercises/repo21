package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

import static gdi.MakeItSimple.*;

public class CompSortMain {

	public static final boolean BUBBLESORT = true;
	public static final boolean INSERTSORT = false;
	
	
	public static void main(String[] args) {
		String[] test1 = {"Hallo", "das", "ist", "nicht", "ausreichend", "getestet"};
		int[] test2 = {2,5,32,3,1,2,343,53,5,46,46};
		int[] test3 = {2,5,32,3,1,2,343,53,5,46,46};
		
		MyInt[] testerTest2 = toMyInt(test2);
		MyInt[] testerTest3 = toMyInt(test3);

		Sort bubSorter = new BubbleSort();
		Sort inSorter = new InsertionSort();
		
		//sortArray(testerTest2, bubSorter);
		//sortArray(testerTest3, inSorter);
		
		printMyIntArray(testerTest2);
		printMyIntArray(testerTest3);
		
	}
	
	public void sortArray(Comparable[] arr, Sort sortType){
		sortType.sort(arr);
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
