package hsm.tpeGroup21.ab01;

import static org.junit.Assert.*;
import org.junit.Test;
import static gdi.MakeItSimple.*;

public class TestBBaum {
	BTree testTree = new BTree(10);
	BTree emptyTree = new BTree(23);
	@Test
	public final void test() {
		assertEquals("Insert(rndmNmbrs.txt): ", true, testTree.insert("rndmNmbrs.txt"));
		assertEquals("size()): ", 100, testTree.size());
		assertEquals("size()): ", 0, emptyTree.size());
		assertEquals("Insert(rndmNmbrs.txt): ", false, testTree.insert("rndmNmbrs.txt"));
		assertEquals("Contains(30): ", true, testTree.contains(new Integer(30)));
		assertEquals("Contains(900): ", false, testTree.contains(new Integer(900)));
		assertEquals("Insert(555): ", true, testTree.insert(new Integer(555)));
		assertEquals("Insert(2): ", false, testTree.insert(new Integer(2)));
		assertEquals("height(): ", 2, testTree.height());
		assertEquals("height(): ", 0, emptyTree.height());
	//	assertEquals("getMax(): ", 555, testTree.getMax());
	//	assertEquals("getMin(): ", 555, testTree.getMin());	
		assertEquals("isEmpty: ", true, emptyTree.isEmpty()) ;
		assertEquals("isEmpty: ", false, testTree.isEmpty());
				
	}

}
