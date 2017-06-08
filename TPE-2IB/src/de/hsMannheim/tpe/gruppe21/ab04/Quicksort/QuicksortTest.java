package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTest {

	@Test
	public void quickSortSequenzTest() {
		Integer[] array = {628, 590, 91, 506, 207, 280, 620, 578, 860, 337, 163, 308, 344, 469, 507, 543, 612, 815, 688, 652 ,310, 61,2 ,595 ,399, 582, 613 ,636 ,354 ,631 ,417 ,889, 778, 237 ,574 ,430 ,91 ,429 ,583 ,362, 896, 819, 505 ,581, 620, 33,3, 6,56, 473, 370 ,492, 890, 538 ,620, 611, 770, 237, 199 ,677, 79, 297 ,834 ,548, 729 ,269, 422, 737, 563, 471, 352, 262, 696 ,438, 497, 279, 921, 796, 532, 711 ,166, 366, 622 ,4,80 ,44 ,711, 842 ,571, 624 ,421, 481 ,428, 503, 454, 308, 709, 375, 208, 793, 577, 966, 463, 576};
		
		SortAlgorithm qs = new QuicksortSequentiell();
		qs.sort(array);
		
		assertTrue(isSorted(array));
	}
	
	@Test
	public void quickSortParallelTest() {
		Integer[] array = {628, 590, 91, 506, 207, 280, 620, 578, 860, 337, 163, 308, 344, 469, 507, 543, 612, 815, 688, 652 ,310, 61,2 ,595 ,399, 582, 613 ,636 ,354 ,631 ,417 ,889, 778, 237 ,574 ,430 ,91 ,429 ,583 ,362, 896, 819, 505 ,581, 620, 33,3, 6,56, 473, 370 ,492, 890, 538 ,620, 611, 770, 237, 199 ,677, 79, 297 ,834 ,548, 729 ,269, 422, 737, 563, 471, 352, 262, 696 ,438, 497, 279, 921, 796, 532, 711 ,166, 366, 622 ,4,80 ,44 ,711, 842 ,571, 624 ,421, 481 ,428, 503, 454, 308, 709, 375, 208, 793, 577, 966, 463, 576};
		
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
