package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class InsertionSort {
	
	public static Comparable[] insertionSort(Comparable[] compareArray){
		for(int i = 1; i < compareArray.length; i++){
			for(int j = i; j > 1; j++){
				if(compareArray[j].compareTo(compareArray[j-1]) == -1){
					swap(compareArray, j, j+1);
				}
			}
		}
		return compareArray;
	}
	
	private static void swap(Comparable[] compareArray, int objectOne, int objectTwo){
		Comparable swapper = compareArray[objectOne];
		compareArray[objectOne] = compareArray[objectTwo];
		compareArray[objectTwo] = swapper;
	}
	
}
