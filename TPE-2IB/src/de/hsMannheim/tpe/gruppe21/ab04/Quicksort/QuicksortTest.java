package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTest {

	@Test
	public void quickSortSequenzTest() {
		Integer[] array = {5,9,4,3,8,2,1,7,6};
		
		SortAlgorithm qs = new QuicksortSequentiell();
		qs.sort(array);
		
		assertTrue(isSorted(array));
	}
	
	@Test
	public void quickSortParallelTest() {
		Integer[] array = {5,9,4,3,8,2,1,7,6};
		
		SortAlgorithm qs = new QuicksortParallel();
		qs.sort(array);
		
		assertTrue(isSorted(array));
	}
	
	@Test
	public void quickSortSequenzTestEmptyArray() {
		Integer[] array = {};
		
		SortAlgorithm qs = new QuicksortSequentiell();
		qs.sort(array);
		
		assertTrue(isSorted(array));
	}
	
	@Test
	public void quickSortParallelTestEmptyArray() {
		Integer[] array = {};
		
		SortAlgorithm qs = new QuicksortParallel();
		qs.sort(array);
		
		assertTrue(isSorted(array));
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
