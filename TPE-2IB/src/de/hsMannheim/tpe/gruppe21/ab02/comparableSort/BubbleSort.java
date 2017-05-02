package de.hsMannheim.tpe.gruppe21.ab02.comparableSort;


public class BubbleSort {

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

	

	private static void swap(Comparable[] compareArray, int objectOne, int objectTwo) {
		Comparable swapper = compareArray[objectOne];
		compareArray[objectOne] = compareArray[objectTwo];
		compareArray[objectTwo] = swapper;
	}

	private static boolean isSorted(Comparable[] compareArray) {
		for (int i = 0; i < compareArray.length; i++) {
			if (compareArray[i].compareTo(compareArray[i - 1]) == -1) {
				return false;
			}
		}
		return true;
	}
}
