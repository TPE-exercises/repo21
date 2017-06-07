package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

public class testMain {

	public static void main(String[] args) {
		//sequentiell
		Integer[] array1 = {1,0,25,-5,10,0,30,4,20,23,50,10,-5};
		System.out.println("BEFORE SEQUENTIELL SORT: ");
		System.out.println(printArray(array1));
		
		long timeSeq = System.currentTimeMillis();
		QuicksortSequentiell sequentiellSorter = new QuicksortSequentiell();
		sequentiellSorter.sort(array1);
		timeSeq = System.currentTimeMillis() - timeSeq;
		
		System.out.println("AFTER SEQUENTIELL SORT: ");
		System.out.println(printArray(array1));
		
		//parallel
		System.out.println(" \nBEFORE PARALLEL SORT: ");
		Integer[] array2 = {1,0,25,-5,10,0,30,4,20,23,50,10,-5};
		System.out.println(printArray(array2));
		
		long timePar = System.currentTimeMillis();
		QuicksortParallel parallelSorter = new QuicksortParallel();
		parallelSorter.sort(array2);
		timePar = System.currentTimeMillis() - timePar;
		
		System.out.println("AFTER PARALLEL SORT: ");
		System.out.println(printArray(array2) + "\n");
		
		if(!isSorted(array1)){
			System.out.println("Array 1 nicht sortiert!");
		}
		if(!isSorted(array2)){
			System.out.println("Array 2 nicht sortiert!");
		}
		
		sequentiellSorter.printNumbers();
		System.out.println("\tZeit: " + timeSeq + "ms");
		parallelSorter.printNumbers();
		System.out.println("\tZeit: " + timePar + "ms");
		
	}
	
	public static String printArray(Comparable[] array){
		String toPrint = "";
		for(int i = 0; i < array.length; i++){
			toPrint += array[i].toString() + "; ";
		}
		return toPrint;
	}
	
	public static boolean isSorted(Comparable[] array){
		for(int i = 0; i < array.length-1; i++){
			if(array[i].compareTo(array[i+1]) > 0){
				return false;
			}
		}
		return true;
	}
}
