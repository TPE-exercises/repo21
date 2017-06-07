package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

public class testMain {

	public static void main(String[] args) {
		//squentiell
		Integer[] array1 = {2,4,2,34,5,64,5};
		System.out.println("Before sequentiel sort: ");
		System.out.println(printArray(array1));
		
		QuicksortSequentiell sequentiellSorter = new QuicksortSequentiell();
		sequentiellSorter.sort(array1);
		
		System.out.println("After sequentiell sort: ");
		System.out.println(printArray(array1));
		
		
		
		//parallel
		System.out.println(" \nBefore parallel sort: ");
		Integer[] array2 = {2,4,2,34,5,64,5};
		System.out.println(printArray(array2));
		
		QuicksortParallel parallelSorter = new QuicksortParallel();
		parallelSorter.sort(array2);
		
		System.out.println("After parallel sort: ");
		System.out.println(printArray(array2));
		
	}
	
	public static String printArray(Comparable[] array){
		String toPrint = "";
		for(int i = 0; i < array.length; i++){
			toPrint += array[i].toString() + "; ";
		}
		return toPrint;
	}
}
