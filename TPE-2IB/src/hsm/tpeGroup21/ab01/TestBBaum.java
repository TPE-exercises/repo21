package hsm.tpeGroup21.ab01;

import static org.junit.Assert.*;
import org.junit.Test;
import static gdi.MakeItSimple.*;

public class TestBBaum {
	BTree[] tree = {new BTree(2), new BTree(10), new BTree(100)};
	@Test
	public final void test() {
		for(int i = 0; i<3; i++){
			println("Baum Nr: " + (i+1) );
			assertEquals("Insert(2): ", true, tree[i].insert(new Integer(2)));
			assertEquals("Contains(2): ", true, tree[i].contains(new Integer(2)));
		}	
	}

}
