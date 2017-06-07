package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

public class QuicksortParallel implements SortAlgorithm {

	@Override
	public void sort(Comparable[] array) {
		Thread startSorter = newQuickSortThread(array, 0, array.length-1);
		startSorter.start();
		try {
			startSorter.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
	/**
	 * creates new Threads for every quicksort recursion
	 * @param array to sort array
	 * @param low lower limit of remaining array
	 * @param up upper limit of remaining array
	 * @return thread that quicksorts the array
	 */
	private Thread newQuickSortThread(Comparable[] array, int low, int up){
		Thread quickSortThread = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					quickSortPar(array, low, up);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		});
		return quickSortThread;
	}

	/**
	 * sorts array with quicksort recursively
	 * @param array array to sort
	 * @param low lower limit of remaining array
	 * @param up upper limit of remaining array
	 * @throws InterruptedException
	 */
	private void quickSortPar(Comparable[] array, int low, int up) throws InterruptedException {
		if(low < up){
			int p = findPiv(array, low, up);
			Thread leftHalf = newQuickSortThread(array, low, p);
			Thread rightHalf = newQuickSortThread(array, p+1, up);
			
			leftHalf.start();
			rightHalf.start();
			
			leftHalf.join();
			rightHalf.join();
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
				left++;
			}
			//right: Index of the first element from position up with array[right]<= piv
			int right = up;
			while(array[right].compareTo(piv) > 0){
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
		Comparable storage = array[toSwapOne];
		array[toSwapOne] = array[toSwapTwo];
		array[toSwapTwo] = storage;
	}
}
