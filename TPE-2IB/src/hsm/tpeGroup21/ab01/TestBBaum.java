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
		assertEquals("Insert(rndmNmbrs.txt): ", false, testTree.insert("rndmNmbrs.txt"));
		assertEquals("Contains(2): ", true, testTree.contains(new Integer(2)));
		assertEquals("Contains(2): ", false, testTree.contains(new Integer(900)));
		assertEquals("Insert(2): ", true, testTree.insert(new Integer(555)));
		assertEquals("Insert(2): ", false, testTree.insert(new Integer(2)));
		assertEquals("size()): ", 31, testTree.size());
		assertEquals("height(): ", 10, testTree.height());
		assertEquals("getMax(): ", 555, testTree.getMax());
		assertEquals("isEmpty: ", true, emptyTree.isEmpty()) ;
		assertEquals("isEmpty: ", false, testTree.isEmpty());
				
	}

}
