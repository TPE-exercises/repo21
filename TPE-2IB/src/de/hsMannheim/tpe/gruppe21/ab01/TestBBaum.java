package de.hsMannheim.tpe.gruppe21.ab01;

import static org.junit.Assert.*;
import org.junit.Test;
import static gdi.MakeItSimple.*;

public class TestBBaum {
	@Test
	public void testAll() {
		BTree testTree = new BTree(10);
		BTree emptyTree = new BTree(23);
		assertEquals("Insert(rndmNmbrs.txt): ", true, testTree.insert("rndmNmbrs.txt"));
		assertEquals("size()): ", 100, testTree.size());
		assertEquals("size()): ", 0, emptyTree.size());
		assertEquals("Insert(rndmNmbrs.txt): ", false, testTree.insert("rndmNmbrs.txt"));
		assertEquals("Contains(2): ", true, testTree.contains(new Integer(2)));
		assertEquals("Contains(900): ", false, testTree.contains(new Integer(900)));
		assertEquals("Insert(555): ", true, testTree.insert(new Integer(555)));
		assertEquals("Insert(555): ", true, testTree.insert(new Integer(-10)));
		assertEquals("Insert(2): ", false, testTree.insert(new Integer(2)));
		assertEquals("height(): ", 2, testTree.height());
		assertEquals("height(): ", 0, emptyTree.height());
		
		Integer expectedMax = 555;
		Integer realMax = testTree.getMax();
		assertEquals("getMax(): ", realMax, expectedMax);
		
		Integer expectedMin = -10;
		Integer realMin = testTree.getMin();
		assertEquals("getMin(): ", realMin, expectedMin);
		
		assertEquals("isEmpty: ", true, emptyTree.isEmpty()) ;
		assertEquals("isEmpty: ", false, testTree.isEmpty());
				
	}
	
	
	@Test
	public void insertTest(){
		boolean insertFailed = false;
		BTree testTree = new BTree(2);
		Integer[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		for(int i = 0; i<values.length; i++){
			if(!testTree.insert(values[i])){
				insertFailed = true;
			}
		}
		assertEquals(false, insertFailed);
		
		if(!testTree.insert(1)){
			insertFailed = true;
		}
		
		
		assertEquals(true, insertFailed);
		
	}
	
	
	@Test
	public void getMaxTest(){
		BTree testTree = new BTree(2);
		Integer[] values = {34,54,2,45,-100,32,5,64,23,56,44,33,22,12,100,67};
		for(int i = 0; i<values.length; i++){
			testTree.insert(values[i]);
		}
		Integer expectedMax = 100;
		Integer realMax = testTree.getMax();
		assertEquals(expectedMax, realMax);
	}
	
	@Test
	public void getMinTest(){
		BTree testTree = new BTree(2);
		Integer[] values = {34,54,2,45,-100,32,5,64,23,56,44,33,22,12,100,67};
		for(int i = 0; i<values.length; i++){
			testTree.insert(values[i]);
		}
		Integer expectedMax = -100;
		Integer realMin = testTree.getMin();
		assertEquals(expectedMax, realMin);
	}
	
	@Test
	public void sizeTest(){
		BTree testTree = new BTree(2);
		Integer[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		for(int i = 0; i<values.length; i++){
			testTree.insert(values[i]);
		}
		assertEquals(values.length, testTree.size());
	}

}
