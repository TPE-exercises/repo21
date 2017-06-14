package de.hsMannheim.tpe.gruppe21.ab05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBBaumIterator {

	public static BTree bt;
	public static BBaumIterator bbi;
	
	@Before
	public void setUp() throws Exception {
		bt = new BTree(5, "rndmNmbrs.txt");
		bbi = new BBaumIterator(bt);
	}

	@Test
	public void testNextAndHasNext() {
		assertTrue(bbi.hasNext());
		while(bbi.hasNext()){
			bbi.next();
		}
		assertEquals(bbi.getValue(), bt.getMax());
	}

	@Test
	public void testRemove() {
		Comparable safer = bt.getMax();
		bbi.remove();
		assertTrue(safer.compareTo(bbi.getValue()) > 0);
	}

}
