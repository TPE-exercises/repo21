package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;

public class BubbleSort {

	
	
	
	/**
	 * 
	 * @param compareArray Array to sort
	 * @return sorted Array
	 */
	public static Comparable[] bubbleSort(Comparable[] compareArray) {
		while (!isSorted(compareArray)) {
			for (int i = 0; i < compareArray.length - 1; i++) {
				if (compareArray[i].compareTo(compareArray[i - 1]) == -1) {
					swap(compareArray, i, i + 1);
				}
			}
		}
		return compareArray;
	}
	
	
	

	/**
	 * @param compareArray
	 *            Array that includes the objects to swap
	 * @param objectOne
	 *            first object to swap
	 * @param objectTwo
	 *            second object to swap
	 * @return comapreArray with swapped objects
	 */
	private static void swap(Comparable[] compareArray, int objectOne, int objectTwo) {
		Comparable swapper = compareArray[objectOne];
		compareArray[objectOne] = compareArray[objectTwo];
		compareArray[objectTwo] = swapper;
	}

	/**
	 * @param compareArray
	 *            Array to check if sorting is correct
	 * @return true if Array is sorted, false if not
	 */
	private static boolean isSorted(Comparable[] compareArray) {
		for (int i = 0; i < compareArray.length; i++) {
			if (compareArray[i].compareTo(compareArray[i - 1]) == -1) {
				return false;
			}
		}
		return true;
	}
}
