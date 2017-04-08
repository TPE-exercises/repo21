package hsm.tpeGroup21.ab01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBBaum {
	BTree[] tree = {new BTree(2), new BTree(10), new BTree(100)};
	@Test
	public final void test() {
		for(int i = 0; i<3; i++){
			assertEquals("Insert(2): ", true, tree[i].insert(new Integer(2)));
			assertEquals("Insert(2): ", false, tree[i].insert(new Integer(2)));
			assertEquals("Insert(4): ", true, tree[i].insert(new Integer(4)));
			assertEquals("Insert(8): ", true, tree[i].insert(new Integer(8)));
			assertEquals("Contains(2): ", true, tree[i].contains(new Integer(2)));
			assertEquals("Contains(3): ", false, tree[i].contains(new Integer(3)));
		}	
	}

}
