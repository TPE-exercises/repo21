package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

public class QuicksortSequentiell implements SortAlgorithm {
	@Override
	public void sort(Comparable[] array) {
		quicksortSeq(array, 0, array.length-1);
	}
	private int rekursionsSchritte = 0;
	private int swaps = 0;
	private int compares = 0;
	
	public int[] getNumbers(){
		int[] nmbrs = {rekursionsSchritte, swaps, compares, 0};
		return nmbrs;
	}
	/**
	 * sorts array with quicksort recursively
	 * @param array array to sort
	 * @param low lower limit of remaining array
	 * @param up upper limit of remaining array
	 */
	private void quicksortSeq(Comparable[] array, int low, int up){
		if(low < up){
			rekursionsSchritte += 2;
			int p = findPiv(array, low, up);
			quicksortSeq(array, low, p);
			quicksortSeq(array, p + 1, up);
		}
	}
	
	/**
	 * Quicksort variant 1
	 * @param array to sort
	 * @param low lower limit of remaining array
	 * @param up upper limit of remaining array
	 * @return index of pivot element
	 */
	private int findPiv(Comparable[] array, int low, int up){
		//p: index of pivot element
		int p = (low + up)/2;
		Comparable piv = array[p];
		while(low <= up){
			//left: Index of the first element from position low with array[left]>= piv
			int left = low;
			while(array[left].compareTo(piv) < 0){
				compares++;
				left++;
			}
			//right: Index of the first element from position up with array[right]<= piv
			int right = up;
			while(array[right].compareTo(piv) > 0){
				compares++;
				right--;
			}
			if(left < right){
				swap(array, left, right);
				low = left +1;
				up = right -1;
			}
			else{
				return right;
			}
		}
		return up;
	}
	
	
	/**
	 * swaps two elements of an array
	 * @param array where elements to swap
	 * @param toSwapOne first element to swap
	 * @param toSwapTwo second element to swap
	 */
	private void swap(Comparable[] array, int toSwapOne, int toSwapTwo){
		swaps++;
		Comparable storage = array[toSwapOne];
		array[toSwapOne] = array[toSwapTwo];
		array[toSwapTwo] = storage;
	}
	
}
