package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class CompSortMain {

	public static final boolean BUBBLESORT = true;
	public static final boolean INSERTSORT = false;
	
	public static void main(String[] args) {
		
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
	
	
}
